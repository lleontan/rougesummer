
import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
public class Game_Applet extends Applet implements Runnable, KeyListener,MouseListener {
	int windowsizex = 700; // window sizes
	public static int windowsizey = 600;
	Unit selectedUnit;
	public static void deletePrefab(ArrayList<cosmeticSprite> list, int unitname) {
		int size = list.size();
		for (int a = 0; a < size; a++) {
			cosmeticSprite spri =list.get(a);
			if (spri.targetname == unitname) {
				list.remove(a);
				break;
			}
		}
	}

	public static void Instantiate(ArrayList<cosmeticSprite> List,cosmeticSprite obj) {
		// USE THIS TO CREATE OBJECTS
		cosmeticSprite spri = obj;

		spri.targetname = gameController.getNewName();
		List.add(spri);
	}

	public static void main(String[] args) {
		Game_Applet app = new Game_Applet();
		app.setVisible(true);
	}

	public gameController controller = new gameController();
	Font font1 = new Font("consolas", Font.PLAIN, 24); // font
	Image offscreen; // offscreen is for buffering stuff

	public Game_Applet() {
		
	}
	public void drawStatPanel(ArrayList<statPanel>list,Graphics2D off){
		int listsize=list.size();
		for(int a=0;a<listsize;a++){
			statPanel p=list.get(a);
			int strListsize=p.textArray.size();
			for(int b=0;b<strListsize;b++){
			cosmeticText t=p.textArray.get(b);
			String cos = t.text;
			
			int x1 = t.x; // temp variables
			int y1 = t.y;
			
			off.drawString(cos, x1, y1);
			}
			
			this.drawList(off, p.imageArray);
		}
	}
	public void drawShip(Graphics2D off){
		for(int b=0;b<gameController.shipList.size();b++){
		ArrayList<Room> rooms=gameController.shipList.get(b).roomArray;
		ship theship=gameController.shipList.get(b);
		int roomnum=rooms.size();
		

			
			int shipx=theship.x;		//pixel coords
			int shipy=theship.y;
			int shipwidth=theship.width;		//size, in pixels
			int shipheight=theship.height;
			int tilesize=theship.tilesize;		//tilesize in pixels
			Image shipImage=theship.defaultImage;
			
			int imgh = shipImage.getHeight(this);
			int imgw = shipImage.getWidth(this); // getting the size of image
											// itself to be able to resize

			float scalex = (float) ((shipwidth + .0) / (imgw + .0)); // scaling stuff
			float scaley = (float) ((shipheight + .0) / (imgh + .0));

			AffineTransform newform = new AffineTransform();
			// use this for rotating, scaling, transforming ect

			float degreesToRadians = (float) (Math.PI / 180);
			float degreemeasure = theship.rotation;
			degreemeasure = degreemeasure + degreesToRadians;
			newform.setToRotation(degreemeasure, theship.x + .5 * theship.width,theship.y + .5 * theship.height);
			newform.translate(theship.x, theship.y); // X AND Y ARE NOT COORDINATES, 
			newform.scale(scalex, scaley); // size rescaling
			
			
			off.drawImage(shipImage, newform, this);
			
			if(theship.showrooms==true){

				for(int a=0;a<roomnum;a++){
					
					int localx=rooms.get(a).xCoord;//grid point in ship
					int localy=rooms.get(a).yCoord;
					int width=rooms.get(a).tileWidth;	//grid length/height
					int height=rooms.get(a).tileHeight;
					Room currentRoom=rooms.get(a);
					
					currentRoom.x=localx*tilesize+theship.x+theship.centerx;
					currentRoom.y=localy*tilesize+theship.y+theship.centery;
					currentRoom.width=theship.tilesize*width;
					currentRoom.height=theship.tilesize*height;
					off.setColor(Color.DARK_GRAY);
					off.fillRect(currentRoom.x, currentRoom.y, currentRoom.width, currentRoom.height);;
					off.setColor(Color.WHITE);
				}
				drawListInShipGrid(off,theship.unitList,b);
		}
		}
	}
	public void drawListInShipGrid(Graphics2D off, ArrayList list,int shipIndex){
		//draws a list inside a ship, cooords, not pixels
		int unitNum=list.size();
		ship theship=gameController.shipList.get(shipIndex);
		for(int a=0;a<unitNum;a++){
			
		int localx=((cosmeticSprite)(list.get(a))).xCoord;//grid point in ship
		int localy=((cosmeticSprite)(list.get(a))).yCoord;
		int width=theship.tilesize;	//grid length/height
		int height=theship.tilesize;
		cosmeticSprite spri=(cosmeticSprite)list.get(a);
		
			spri.x=localx*theship.tilesize+theship.x+theship.centerx;
		spri.y=localy*theship.tilesize+theship.y+theship.centery;

		off.setColor(Color.ORANGE);
		off.fillOval(spri.x, spri.y, spri.width, spri.height);
		off.setColor(Color.WHITE);
		}
	}
	public void drawList(Graphics2D off, ArrayList<cosmeticSprite> list) {
		int tempSize = list.size(); // we're doing forloops with temp variables
									// for preformance
		for (int a = 0; a < tempSize; a++) {
			cosmeticSprite cos = list.get(a);// getting the transform and sprite
				

				int tileSize=gameController.tileSize;
				int x1 = cos.x; // temp variables
				int y1 = cos.y;
				if(cos.useCoords==true){
					cos.xCoord=x1/tileSize;	//my xy to coords equation is probably wrong
					cos.yCoord=y1/tileSize;
					x1=cos.xCoord*tileSize;
					y1=cos.yCoord*tileSize;
				}
				
				int height = cos.height;
				int width = cos.width;
				Image img = cos.defaultImage; // getting image


				int imgh = img.getHeight(this);
				int imgw = img.getWidth(this); // getting the size of image
												// itself to be able to resize

				float scalex = (float) ((width + .0) / (imgw + .0)); // scaling stuff
				float scaley = (float) ((height + .0) / (imgh + .0));

				AffineTransform newform = new AffineTransform();
				// use this for rotating, scaling, transforming ect

				float degreesToRadians = (float) (Math.PI / 180);
				float degreemeasure = cos.rotation;
				degreemeasure = degreemeasure + degreesToRadians;
				newform.setToRotation(degreemeasure, cos.x + .5 * cos.width,cos.y + .5 * cos.height);
				cos.rotation = 0;

				newform.translate(x1, y1); // X AND Y ARE NOT COORDINATES, 
				newform.scale(scalex, scaley); // size rescaling
				off.drawImage(img, newform, this);
				// off.drawImage(img,x1, y1, this);
			
		}
	}

	public void excecuteListAI(ArrayList<Unit> list)
			throws IOException {
		// excecutes the AI state machines of all units in the given arraylist

		int size = list.size();
		for (int a = 0; a < size; a++) {
			// try{
			size = list.size();
			Unit sol;
			if (a >= size) {
				break;
			}
			list.get(a).executeAI();;
			
		}
	}

	public float findDistance(ArrayList list, ArrayList targetList,
			int shooterName, int targetName) {
		Unit shooter = (Unit) list.get(shooterName);
		Unit targetSol = (Unit) list.get(targetName);
		float distance = (float) (Math.sqrt(Math
				.pow(shooter.x - targetSol.x, 2)
				+ Math.pow(shooter.y - targetSol.y, 2)));

		return distance;
	}

	public int findname(ArrayList list, String findString) {
		// scans through the list for something named the string and returns the address
		// -1 for nothing
		int returnAddress = -1;

		int tempSize = list.size();
		for (int a = 0; a < tempSize; a++) {
			Unit tempSol = (Unit) list.get(a);
			String tempname = tempSol.displayName;
			if (tempname.equals(findString)) {
				returnAddress = a;
			}
		}
		return returnAddress;
	}

	@Override
	public void init() {
		setSize(windowsizex, windowsizey);
		setBackground(Color.WHITE);
		
		ship playersShip;
		statPanel uiPanel=new statPanel();
		
		//uiPanel.textArray.add(txt1);
		uiPanel.x=100;
		uiPanel.y=400;
		gameController.UIPanelList.add(uiPanel);
		try {
			playersShip = new playerShip();
			playersShip.x=50;
			playersShip.y=230;
			gameController.shipList.add(playersShip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		addKeyListener(this); // add listeners here
		addMouseListener(this);
	}

	@Override
	public void keyPressed(KeyEvent key) {
	}

	@Override
	public void keyReleased(KeyEvent key) {

	}

	@Override
	public void keyTyped(KeyEvent key) {
		char typed=key.getKeyChar();
		if(selectedUnit!=null){
		switch(typed){
		case 'w':
			selectedUnit.moveTile(4);
			break;
		case 'a':
			selectedUnit.moveTile(3);
			break;
		case 's':
			selectedUnit.moveTile(2);
			break;
		case 'd':
			selectedUnit.moveTile(1);
			break;
		case ' ':
			
			break;
		}
		}
	}

	@Override
	public void mouseClicked(MouseEvent mouse) {
		// clicked and released
		int buttonPressed = mouse.getButton();
		int x = mouse.getX();
		int y = mouse.getY();

		Collisions col = new Collisions();
		// collisions object, checks positions

		// in collisions create another method that returns all
		// things at the position instead of just the first one
	}

	@Override
	public void mouseEntered(MouseEvent mouse) {
		// when the mouse enters the applet window
	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// mouse held
		// implement click and drag selection
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// mouse released
	}

	@Override
	public void paint(Graphics paint) {
		// when painting paint background objects first
		Graphics2D g = (Graphics2D) paint;
		//int tempSize = gameController.tileList.size(); // temp variable for
															// preformance
															// reasons

		offscreen = createImage(windowsizex, windowsizey);
		Graphics2D off = (Graphics2D) offscreen.getGraphics();

		drawList(off, gameController.cosmeticList);
		this.drawShip(off);
		this.drawStatPanel(gameController.UIPanelList, off);
		// we're going to use graphics 2d to do all our painting instead of just
		// graphics
		/*
		 * AffineTransform for rotation;
		 * 
		 * g.drawImage(img, xform, this);
		 */

		paint.drawImage(offscreen, 0, 0, this);
	}

	public int RandomNumber(int range, int min) { // returns a random integer
		int returnnum = (int) (Math.random() * range + min);
		return returnnum;
	}

	public void rotatePrefab(float degrees) {
		//
	}

	public void run() {
		try {
			Thread.currentThread().setPriority(Thread.MIN_PRIORITY); // threading
																		// stuff
			while (true) {
				
				// update loop

				controller.excecuteController();	//
				
				
				repaint(); // end of run method
				Thread.sleep(35);
				Thread.yield();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void start() {

		Thread th = new Thread(this);
		th.start();
	}

	@Override
	public void stop() {
	}
}
