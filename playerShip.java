import java.io.IOException;


public class playerShip extends ship{
	public playerShip() throws IOException{
		this.assetPath="C:\\Users\\Leon Tan\\git\\rougesummer\\sprites\\Tank1.jpg";
		this.defaultImage=this.get_image(this.assetPath);
		
		
		this.centerx=40;
		this.centery=40;
		this.width=200;
		this.height=200;
		
		this.showrooms=true;
		this.useCoords=false;
		this.tilesize=10;
		
		Room r1=new Room(0,2,4,6);
		this.addRoom(r1);

		Room r2=new Room(4,0,4,6);
		this.addRoom(r2);
		Room r3=new Room(8,2,4,6);
		this.addRoom(r3);
		
		baisicUnit unit1=new baisicUnit(5,5);
		baisicUnit unit2=new baisicUnit(6,4);
		this.addUnit(unit1);
		this.addUnit(unit2);
		
		system shield=new shieldSystem(1,5);
	}
}
