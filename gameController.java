

import java.io.IOException;
import java.util.ArrayList;

public class gameController {
	long[] waveTimer = new long[3];
	int waveNumber = 0;
	public static int tileSize=40;

	static public ArrayList<cosmeticSprite> cosmeticList = new ArrayList<cosmeticSprite>(); // this is our arraylist of cosmetic battlefield damage(blown up trees)
	static public ArrayList <cosmeticSprite>tempCosemeticList = new ArrayList<cosmeticSprite>(); // arraylist of temporary battle damage(bullet holes, explosions)
	static public ArrayList<cosmeticSprite> Unitlist = new ArrayList<cosmeticSprite>();
	static public ArrayList<cosmeticSprite> tileList = new ArrayList<cosmeticSprite>(); // arraylist of all structures, ai and player(trees, rocks, trenches)

	public static int namecount = 0;// current name index,

	public static int findListDistance(ArrayList<Unit> list, ArrayList<Unit> targetList,int unitIndex) {
		// finds the closest thing in the arraylist
		// returns the arrayList index

		// -1 for nothing
		int size = list.size();
		Unit sol = null;
		for (int a = 0; a < size; a++) {
			sol = list.get(a);
			if (sol.targetname == unitIndex) {
				break;
			}
		}
		float lowestDistance = -1;
		int lowestDistanceReference = -1;

		int targetlistsize = targetList.size();
		for (int a = 0; a < targetlistsize; a++) {
			Unit targetSol =  targetList.get(a);
			if (targetSol.isDead == true|| targetSol.invisible_to_player == true) {}
			else {
				// gabe check my distance code
				float distance = (float) (Math.sqrt(Math.pow(sol.x
						- targetSol.x, 2)
						+ Math.pow(sol.y - targetSol.y, 2)));
				// L
				if (a == 0) {
					lowestDistance = distance;
					lowestDistanceReference = targetSol.targetname;
				} else if (distance < lowestDistance) {
					lowestDistance = distance;
					lowestDistanceReference = targetSol.targetname;
				}
			}
		}
		return lowestDistanceReference;
	}

	public static int findAtPoint(int xCoord,int yCoord,int direction,int length,ArrayList<cosmeticSprite> list){
		int returnindex=-1;
		

		if(4==direction){
			yCoord=yCoord+length;
		}
		else if(2==direction){
			yCoord=yCoord+length;
		}
		else if(1==direction){
			xCoord=xCoord+length;
		}
		else if(3==direction){
			xCoord=xCoord+length;
		}
		
		int size=list.size();
		for(int a=0;a<size;a++){
			cosmeticSprite spri= list.get(a);
			if(spri.xCoord==xCoord&&spri.yCoord==yCoord){
				returnindex=a;
				break;
			}
		}
		return returnindex;
	}

	public static int getNewName() {
		// uses the class to find a name
		namecount++;
		return namecount;
	}

	public gameController() {
		namecount = 0;
	}

	public void excecuteController() throws IOException {
		// call this from run
		// call all other methods from this
		// Game_Applet.Instantiate( obj);

	}
}
