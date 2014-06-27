import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;



public abstract class ship extends cosmeticSprite {
	//we may or may not need to have it extend cosmetic sprite
	public int roomindex=0,unitindex=0,systemindex=0;
	public int shield=0,shieldRegen=1;		//current shield strength,regen time in turns
	public int power=10,maxPower=10, powerRegen;//we may or may not use power regen					//system power
	public int mana,manaClips,manaClipCharge;			//mana battery system because why not. (I'll explain how this works later)
	public int health=20;
	public int shipOxychange=0,oxy=100;						//-+ oxygen shipwide change per turn
	public ArrayList statusList;		//ship wide statuses
	public  ArrayList<Room>roomArray=new <Room>ArrayList();			//array of rooms. will be overlayed ontop of the ship background(like in ftl)
	public ArrayList<Unit> unitList=new<Room> ArrayList();		//list of friendly units
	public ArrayList <system> systemList=new ArrayList();					//map of systems, each system will be indexed to the room number
	public TreeMap occupiedTiles=new TreeMap();			//map of occupied tiles, each unit updates its position each time it moves, contains arrays of x,y
	
	public int centerx=0,centery=0;		//this is added to the room x,y's to center them in the middle of the ship
	public int tilesize=gameController.tileSize;	//size of each room tile in a ship
	boolean showrooms=true;
	public void turnCheck(){
		//at the end of each turn, this is called,
		//changes Oxy,resets unit AP, regens power & mana, implements statuses,ect
		}
	public void attackRoom(ship theship,int damage,Room theroom){
		int difference=theship.shield-damage;
		theship.shield=difference;
		if(difference<0){
			theship.shield=0;
			theship.health=theship.health-difference;
			int systemsize=theship.systemList.size();
			ArrayList<system> systemlist=theship.systemList;
			for(int a=0;a<systemsize;a++){
				int systemLocation=systemlist.get(a).roomIndex;
				if(theroom.targetname==systemLocation){
					theship.systemList.get(a).health+=difference;
				}
			}
		}
	}
	public void addRoom(Room room){
		room.targetname=this.roomindex;
		roomindex++;
		this.roomArray.add(room);
	}
	public void addUnit(Unit unit){
		unit.targetname=this.unitindex;
		unitindex++;
		this.unitList.add(unit);
	}
	public void addSystem(system system1){
		system1.targetname=this.systemindex;
		systemindex++;
		this.systemList.add(system1);
	}
	public void updateOccupiedTiles(){
		int unitsize=this.unitList.size();
		for(int a=0;a<unitsize;a++){
			Unit theUnit=this.unitList.get(a);
			int[]unitlocation={theUnit.xCoord,theUnit.yCoord};
			this.occupiedTiles.put(theUnit.targetname,unitlocation );
		}
	}
}
