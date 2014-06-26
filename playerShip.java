import java.io.IOException;


public class playerShip extends ship{
	public playerShip() throws IOException{
		this.assetPath="//rougesummer//sprites//Tank1.jpg";
		this.defaultImage=this.get_image(this.assetPath);
		
		this.useCoords=false;
		
		
		Room r1=new Room(0,0,4,6);
		this.roomArray.add(r1);
	}
}
