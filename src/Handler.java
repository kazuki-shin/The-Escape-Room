/*
 * Kazuki Shin
 * 2nd Period
 * 5/21/17
 * Gallatin
 */

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Random;


//This class handles actions to all objects in the game
public class Handler 
{

	public LinkedList<Gameobject> object = new LinkedList<Gameobject>();
	
	private Gameobject tempObject;
	
	private Camera cam;
	public static int Level = 1;
	
	GameTimer timer;
	
	int heartCount;
	
	private BufferedImage level2 = null, level = null,level3 = null,level4 = null,level5 = null, level6=null;
	private Player player;
	Random r = new Random();
	/*
	 * Constructs a Handler object
	 * @param cam the game camera
	 */
	public Handler(Camera cam){
		this.cam = cam;
		timer = new GameTimer();
		BufferedImageLoader loader = new BufferedImageLoader();
	    level =loader.loadImage("/level_1.png");
	    level2 = loader.loadImage("/level_2.png");
	    level3 =loader.loadImage("/level_3.png");
	    level4 =loader.loadImage("/level_4.png");
	    level5 =loader.loadImage("/level_5.png");
	    level6 = loader.loadImage("/level_6.png");
	    heartCount = 5;
	   
	}
	/*
	 * Updates the game logic for all objects in the list
	 */
	public void tick()
	{
		
		
	     for(int i = 0; i < object.size(); i++)
	     {
	    	 tempObject = object.get(i);
	    	 
	    	 tempObject.tick(object);
	     }	
	}
	/*
	 * Updates the graphics on the screen 
	 * @param g the Graphics used to updates the objects in the list
	 */
	public void render(Graphics g)
	{
	     for(int i = 0; i < object.size(); i++)
	     {
	    	 tempObject = object.get(i);
	    	 
	    	 tempObject.render(g);
	     }	
	}
	/*
	 * adds a snow object to the list
	 * @param snowCount amt of snow to add
	 * @param blocks x coordinate of the snow
	 */
	public void spawnsnow(int snow_count, int blocks){
		addobject(new Snow(r.nextInt(32 * (blocks * 2)),-64,Objectid.Snow));
		
	}
	/*
	 * clears all objects in the list
	 */
	public void  clearlevel(){
		object.clear();
	}
	/*
	 * adds a specified object to the list
	 * @param object the object being added
	 */
	public void addobject(Gameobject object){
		this.object.add(object);
	}
	/*
	 * removes an object from the list
	 * @param object the object being removed
	 */
	public void removeobject(Gameobject object){
		this.object.remove(object);
	}
	
	/*
	 * resets the game timer
	 */
	public void resetTimer(){
		timer.resetGameTime();
	}
	
	/*
	 * Loads and draws the image of the level specified
	 * @param image the picture used to create level
	 */
	public void LoadImagelevel(BufferedImage image){
		timer.startGameTime();
		
		int w = image.getWidth();
		int h = image.getHeight();
		
		System.out.println("width, height: " + w + " " + h);
		
		for(int xx = 0; xx < h;xx++){
			for(int yy = 0;yy < w; yy++){
				int pixel = image.getRGB(xx, yy);
				int red = (pixel >> 16)& 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;

				if(red == 255 && green == 255 & blue == 255) addobject(new Block(xx*32, yy*32, Objectid.block)); 
				if(red == 128 && green == 128 & blue == 128) addobject(new Spike(xx*32, yy*32, Objectid.Spike));
				if(red == 128 && green == 128 & blue == 131) addobject(new Spike(xx*32, yy*32, Objectid.Spike2));
				if(red == 128 && green == 128 & blue == 132) addobject(new Spike(xx*32, yy*32, Objectid.Spike3)); 
				if(red == 128 && green == 128 & blue == 150) addobject(new Spike(xx*32, yy*32, Objectid.Spike4)); 
			    if(red == 0 && green == 0 & blue == 255) addobject(new Player(xx*32, yy*32, this,cam, Objectid.player));
			    if(red == 255 && green == 255 & blue == 0) addobject(new Flag(xx*32, yy*32, Objectid.flag));
			    if(red == 110 && green == 110 & blue == 0) addobject(new Key(xx*32, yy*32, Objectid.Key));
			    if(red == 128 && green == 50 & blue == 0) addobject(new Door(xx*32, yy*32, Objectid.Door));
			    if(red == 255 && green == 0 & blue == 0) addobject(new Block(xx*32, yy*32, Objectid.block));
			   
              }
		}
}
	/*
	 * Moves the player to the next level in the game
	 */
	public void switchlevel(){
		clearlevel();
		cam.setx(0);
		
		switch(Game.Level){
		    case 1:
			    LoadImagelevel(level2);
			    Level = 2;
			    break;
		    case 2:
		    	LoadImagelevel(level3);
		    	Level = 3;
		    	break;
		    case 3:
		    	LoadImagelevel(level4);
		    	Level = 4;
		    	break;
		    case 4:
		    	LoadImagelevel(level5);
		    	Level = 5;
		    	break;
		    case 5:
		    	LoadImagelevel(level6);
		    	Level = 6;
		    	break;
		    case 6:	
		    	//game.State = game.State.MENU;
		    	LoadImagelevel(level6);
		    	Level = 6;
                break;
		    case 7:
		    	Game.State = Game.State.WINMESSAGE;
		    	break;
				
		}
		Game.Level++;
	    Game.snow_count = 1;
		
}
/*
 * Restarts the level from scratch
 */
public void restartlevel(int Level){
		
		if(Level == 1){
			clearlevel();
		    LoadImagelevel(level);
		}else if(Level == 2){
			clearlevel();
			LoadImagelevel(level2);
		}else if(Level == 3){
			clearlevel();
			LoadImagelevel(level3);
		}else if(Level == 4){
			clearlevel();
			LoadImagelevel(level4);
		}else if(Level == 5){
			clearlevel();
			LoadImagelevel(level5);
		}else if(Level == 6){
			clearlevel();
			LoadImagelevel(level6);
		}
	}

	/*
	 * Returns the number of hearts the player has
	 * @return heartCount the amt of hearts the player has
	 */
	public int getHeartCount(){
		return heartCount;
	}
	/*
	 * Decreases the heart count by 1
	 */
	public void decreaseHeart(){
		heartCount--;
	}
	/*
	 * Resets the heart count to max
	 */
	public void resetHearts(){
		heartCount = 5;
	}
	/*
	 * Removes the door from list after player obtains key
	 */
	public void cleardoor(Gameobject object){
		removeobject(object);
	}

	/*
	 * Returns the time left in the game
	 * @return the time left in the game
	 */
	public String getGameTime(){
		return timer.getGameTime();
	}
	
	/*
	 * Returns the game timer
	 * @return the game timer
	 */
	public GameTimer getTimer(){
		return timer;
	}
		
}

