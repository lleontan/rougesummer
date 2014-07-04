import java.io.IOException;


public class enemyShip1 extends ship{
	public enemyShip1() throws IOException{
		this.assetPath="sprites/Tank1.jpg";
		this.defaultImage=this.get_image(this.assetPath);
		
		
		this.centerx=50;
		this.centery=40;
		this.width=230;
		this.height=250;
		
		
		this.showrooms=true;
		this.useCoords=false;
		this.tilesize=10;
		
		Room r1=new Room(0,1,5,8);
		this.addRoom(r1);

		Room r2=new Room(2,9,7,4);
		this.addRoom(r2);
		Room r3=new Room(8,3,4,6);
		this.addRoom(r3);
		Room r4=new Room(5,-1,5,4);
		this.addRoom(r4);
		
		
		system shield=new shieldSystem(1,5,1);
		
	}
}
