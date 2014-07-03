import java.awt.Image;
import java.util.ArrayList;
public class statPanel extends cosmeticSprite{
	//a panel is baisically thing that contains UI info for easy use
	//this one will contain a player health information, remaining power,
	ArrayList<cosmeticText> textArray;
	ArrayList<cosmeticSprite> imageArray;
	statPanel(){
String str="health "+100;
		textArray=new ArrayList<cosmeticText>();
		imageArray=new ArrayList<cosmeticSprite>();
		cosmeticText txt1=new cosmeticText();
		txt1.text=str;
		txt1.y+=100;
		textArray.add(txt1);
	}
}
