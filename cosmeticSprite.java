

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class cosmeticSprite {
	// public Game_Applet app=new Game_Applet();//use this to call any methods
	// from the applet
	public int x, y, height, width,face;
	public int xCoord,yCoord;
	public boolean useCoords=true;
	public String assetPath;// the path to the directory with the art
	public Image defaultImage;
	public boolean invisible_to_player = false;

	public int occupytype=0;//1 is normal,2 is air, 3 is
	public boolean isOccupied=false;//if a unit occupies it is true
	
	public Image altSprites[] = new Image[4];		//
	public String altSpritesPath[] = new String[4];

	public float rotation = 0;
	public int targetname, enemytargetname;
	public String displayname = "asdf";
	
	public cosmeticSprite() {
		// targetname=0;
	}

	public Image get_image(String url) throws IOException {
		// gets an image using a given url, can take from internet or file
		// directory
		//matts mighty skill is making this use local files stored in sprites/[filename]
		File file = new File(url);
		java.net.URL f = new File(url).toURI().toURL();
		Image returnImage = ImageIO.read(file);
		return returnImage;
	}
}
