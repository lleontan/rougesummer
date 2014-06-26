import java.util.ArrayList;
import java.util.List;


public class Room extends cosmeticSprite{
	
	//baisically rooms shouldnt' start with walls. walls should be generated when the ship is created
	//tiles should be designated as doortiles, when two doortiles from two different rooms in the same ship are
	//adjacent they should form a door
	
	//we need a filler whitespace for room backgrounds
	public int health,oxy,oxyChange;
	public int disabled=0;		//
	public int fireLevel=0;		//amount of fire in a room
	public int tileWidth=1,tileHeight=1;	//size in tiles
	public ArrayList<int[]> doorTiles;
	
	public Room(int localXCoord, int localYCoord,int tileWidth,int tileHeight){
		this.useCoords=true;
		this.xCoord=localXCoord;
		this.yCoord=localYCoord;
		this.tileWidth=tileWidth;
		this.tileHeight=tileHeight;
	}
	public void addDoor(int xCoord,int yCoord){
		int xy[]={xCoord,yCoord};
		doorTiles.add(xy);
	}
}
