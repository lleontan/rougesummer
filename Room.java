import java.util.List;


public abstract class Room {
	
	//baisically rooms shouldnt' start with walls. walls should be generated when the ship is created
	//tiles should be designated as doortiles, when two doortiles from two different rooms in the same ship are
	//adjacent they should form a door
	
	public int health;
	public int disabled;		//is a timer in turns
	public int fireLevel=0;		//amount of fire in a room
	public int width,height;	//size in tiles
	public List<Integer> doorTiles;
	public Room(){}
	public Room(int width,int height){
		this.width=width;
		this.height=height;
	}
	
}
