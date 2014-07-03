

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;

import javax.swing.text.html.HTMLDocument.Iterator;

public class gameController {
	long[] waveTimer = new long[3];
	int waveNumber = 0;
	public static int tileSize=40;

	static public ArrayList<cosmeticSprite> cosmeticList = new ArrayList<cosmeticSprite>(); // this is our arraylist of cosmetic battlefield damage(blown up trees)
	static public ArrayList <cosmeticSprite>tempCosemeticList = new ArrayList<cosmeticSprite>(); // arraylist of temporary battle damage(bullet holes, explosions)
	static public ArrayList<ship> shipList=new ArrayList<ship>();		//ships, ship crews and rooms are inside the ships in this arraylist
	static public ArrayList<statPanel> UIPanelList=new ArrayList<statPanel>();
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
		return lowestDistanceReference;
	}

	public static boolean checkIfOccupied(int xCoord,int yCoord,int direction,int length,int shipindex){
		boolean canMove=true;
		
		TreeMap map=gameController.shipList.get(shipindex).occupiedTiles;
		Collection collect=map.values();
		java.util.Iterator iterator=collect.iterator();
		

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
		while(iterator.hasNext()){
			int xy[]=(int[]) iterator.next();
			if(xy[0]==xCoord & xy[1]==yCoord){
				//System.out.println("invalid move");
				canMove=false;
				break;
			}
		}
		return canMove;
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

	public static Unit findUnitAtPoint(int newxCoord, int newyCoord, int shipIndex) {
		Unit returnVal = null;
		ArrayList <Unit>unitList=gameController.shipList.get(shipIndex).unitList;
		int size=unitList.size();
		for(int a=0;a<size;a++){
			Unit unit= unitList.get(a);
			if(unit.xCoord==newxCoord & unit.yCoord==newyCoord){
				returnVal=unitList.get(a);
			}
		}
		return returnVal;
		
	}
}
