


import java.io.IOException;
import java.util.ArrayList;
public abstract class Unit extends cosmeticSprite {
	// this is a soldier class, all soldiers inherit from this class

	public float baseAP = 5; // base AP

	public float baseMoveSpeed; // base speed
	public int mana=10;			//we may or may not use a mana system.
	public int manaRegen=1;		//if we use mana we should have a regen per turn		

	public int health = 100;
	public int shipIndex;			//1 for player, 2 for ai

	public int state = -1; // soldier state
	public int moveType=1;//normal,flying,phased
	String displayName = "IsUnit";// name displayed
	
	public long TimerExample[] = { 500, 500, 500, -1 };// 0 is timer,1 is
														// current duration, 2
														// is base duration, 4
														// is the lock

	public Unit() {
		this.useCoords=true;
	}
	public abstract void executeAI();


	public void damage(int ammount) throws IOException {
		health = health - ammount;
		if (health < 1){
			//execute kill comand
		}
	}

	public void doMove(int direction,int length) {
		int newyCoord=this.yCoord;
		int newxCoord=this.xCoord;
			switch(direction){
			case 4:
			//w a s d
				this.yCoord=this.yCoord+length;
			break;
			case 2:
				this.yCoord=this.yCoord+length;
			break;
			case 3:
				this.xCoord=this.xCoord+length;
			break;
			case 1:
				this.xCoord=this.xCoord+length;
			break;
		
		}

		this.x=this.xCoord*gameController.tileSize;
		this.y=this.yCoord*gameController.tileSize;
	}

	public void generateName() {
		//right now it randomly selects a name from the array
		String nameArray[] = { "sammy", "dave","carl" };
		displayName = nameArray[(int) (Math.random() * nameArray.length)];
	}

	public float rotateToPosition(ArrayList list, int enemytargetname) {
		//improve this
		float theta = 0;
		int size = list.size();
		for (int a = 0; a < size; a++) {
			Unit sol = (Unit) list.get(a);
			if (sol.targetname == enemytargetname) {
				int x2 = sol.x;
				int y2 = sol.y;
				float xdis = x2 - this.x;
				float ydis = y2 - this.y;
				float tan = ydis / xdis;
				theta = (float) ((float) Math.atan(tan) + ((-90 * Math.PI) / 180));
				break;
			}
		}
		return theta;
	}

	public void setMoveOrders(int x, int y) {
	}
	public void moveTile(int direction){
		//in order to use wasd controls, simply make a switch statment and have it call moveTile
		switch(direction){
		case 4:
		//w a s d
			this.face=4;
			//this.y=this.y+1;
			movePosition(4,-1);
		break;
		case 2:
			
			this.face=2;
			movePosition(2,1);
		break;
		case 3:
			this.face=3;
			movePosition(3,-1);
		break;
		case 1:
			this.face=1;
			movePosition(1,1);
		break;
	}
	}
	public void movePosition(int direction,int length){
		boolean canMove=gameController.checkIfOccupied(this.xCoord, this.yCoord,direction,length, this.shipIndex);
		if(canMove==true){
				doMove(direction,length);
			}
		}
}
