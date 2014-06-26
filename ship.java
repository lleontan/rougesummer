import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;



public abstract class ship extends cosmeticSprite {
	//we may or may not need to have it extend cosmetic sprite
	public int power,maxPower, powerRegen;					//system power
	public int mana,manaClips,manaClipCharge;			//mana battery system because why not. (I'll explain how this works later)
	public int health;
	public int shipOxychange;						//-+ oxygen shipwide change per turn
	public ArrayList statusList;		//ship wide statuses
	public  List<Room>roomArray;			//array of rooms. will be overlayed ontop of the ship background(like in ftl)
	public ArrayList<Unit> unitList;		//list of friendly units
	public TreeMap systemList;					//map of systems, each system will be indexed to the room number
	public TreeMap occupiedTiles;			//map of occupied tiles, each unit updates its position each time it moves, contains arrays of x,y
	public void turnCheck(){
		//at the end of each turn, this is called,
		//changes Oxy,resets unit AP, regens power & mana, implements statuses,ect
		}
}
