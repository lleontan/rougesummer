import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;



public abstract class ship extends cosmeticSprite {
	//we may or may not need to have it extend cosmetic sprite
	public int power=10,maxPower=10, powerRegen;//we may or may not use power regen					//system power
	public int mana,manaClips,manaClipCharge;			//mana battery system because why not. (I'll explain how this works later)
	public int health=20;
	public int shipOxychange=0,oxy=100;						//-+ oxygen shipwide change per turn
	public ArrayList statusList;		//ship wide statuses
	public  ArrayList<Room>roomArray=new <Room>ArrayList();			//array of rooms. will be overlayed ontop of the ship background(like in ftl)
	public ArrayList<Unit> unitList=new<Room> ArrayList();		//list of friendly units
	public TreeMap systemList=new TreeMap();					//map of systems, each system will be indexed to the room number
	public TreeMap occupiedTiles=new TreeMap();			//map of occupied tiles, each unit updates its position each time it moves, contains arrays of x,y
	
	public int centerx=0,centery=0;		//this is added to the room x,y's to center them in the middle of the ship
	public int tilesize=gameController.tileSize;	//size of each room tile in a ship
	boolean showrooms=true;
	public void turnCheck(){
		//at the end of each turn, this is called,
		//changes Oxy,resets unit AP, regens power & mana, implements statuses,ect
		}
}
