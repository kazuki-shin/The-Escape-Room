/*
 * Kazuki Shin
 * 2nd Period
 * 5/21/17
 * Gallatin
 */

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
 
//Main class which keeps track of the main game logic and graphics of the maze
public class Game extends Canvas implements Runnable
{
	public static void main(String args[]){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		new Window((int)screenSize.getWidth(), (int)screenSize.getHeight(), "Kazuki CSIII Final Project", new Game());
	}
	
	private static final long serialVersionUID = 9050717834283562499L;
    public int loadlevel = 0;
	private boolean running = false;
	private Thread thread;
	private int update = 0;
	private int run = 1;
	private int spawn = 1;
	
	public static int WIDTH, HEIGHT;
	public boolean won;
	
	public BufferedImage level = null,level2 = null,level3 = null,level4 = null,level5 = null, level6 = null;
	
	Gameobject object;
	STATE state;
	private Menu menu;
	public static int Level = 1;
	public static int llevel1 = 0;
	public static int llevel2 = 0;
	public static int llevel3 = 0;
	public static int llevel4 = 0;
	public static int llevel5 = 0;
	public static int llevel6 = 0;
	public static int snow_count = 1;

	// object
	Handler handler;
	Camera cam;
	static Texture tex;
	
	/*
	 * Keeps track of the state of the game
	 */
	public enum STATE {
	    MENU,
	    GAME,
	    WINMESSAGE,
	    HELP,
	    DEATH;
	}

	public static STATE State = STATE.MENU;

	/*
	 * Initializes the maze's images and objects
	 */
	private void init(){
		WIDTH = getWidth();
		HEIGHT = getHeight();
		
		tex = new Texture();
		
		BufferedImageLoader loader = new BufferedImageLoader();
		level =loader.loadImage("/level_1.png");
		level2 =loader.loadImage("/level_2.png");
		level3 =loader.loadImage("/level_3.png");
		level4 =loader.loadImage("/level_4.png");
		level5 =loader.loadImage("/level_5.png");
		level6 = loader.loadImage("/level_6.png");
		cam = new Camera(0, 0);
		handler = new Handler(cam);
	
	   menu = new Menu();
		this.addKeyListener(new keyinput(handler));
		this.addMouseListener(new MouseInput());
		
		won = false;
	}
	/*
	 * starts the game thread
	 */
	public synchronized void start()
	{
		if(running)
			return;
			
		running = true;	
		thread = new Thread(this);
		thread.start();
		
	}
	
	/*
	 * method for running the games thread
	 */
	public void run()
	{
		if(run == 1){
			Player.key = false;
		}
		init();
		loadlevel();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				updates++;
				delta--;
			}
			
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
				if(State == State.GAME){
					
				
				if(snow_count <= 16){
					handler.spawnsnow(snow_count,19);
					snow_count ++;
					
				}
				}
				loadlevel();
				
						
			llevel1 = 0;
			llevel2 = 0;
			llevel3 = 0;
			llevel4 = 0;
			llevel5 = 0;
			llevel6 = 0;
			if(update == 0){
				
			update = 1;
			
			}
			}
		}
	}
	
	/*
	 * Loads the next level and resets heart to max
	 */
	private void loadlevel() {
		snow_count = 1;
		if(llevel1 == 1){
			handler.clearlevel();
			handler.LoadImagelevel(level);
			handler.resetHearts();
		}else if(llevel2 == 1){
			handler.clearlevel();
			handler.LoadImagelevel(level2);
			handler.resetHearts();
		}else if(llevel3 == 1){
			handler.clearlevel();
			handler.LoadImagelevel(level3);
			handler.resetHearts();
		}else if(llevel4 == 1){
			handler.clearlevel();
			handler.LoadImagelevel(level4);
			handler.resetHearts();
		}else if(llevel5 == 1){
			handler.clearlevel();
			handler.LoadImagelevel(level5);
			handler.resetHearts();
		}else if(llevel6 == 1){
			handler.clearlevel();
			handler.LoadImagelevel(level6);
			handler.resetHearts();
			
		}
		
	}
	/*
	 * Updates the game logic for the full Game
	 */
	private void tick()
	{
		if (State == STATE.GAME){
		handler.tick();
		for(int i = 0; i < handler.object.size(); i++){
			if(handler.object.get(i).getId() == Objectid.player){
				cam.tick(handler.object.get(i));
			}
			}
		}
	}
	
	/*
	 * Updates the graphics on the screen for all objects
	 */
	private void render()
	{
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		/////////////////////////////////////////////////////
		
		//draw screen
		g.setColor(Color.black);
		g.fillRect(0, 0,getWidth(),getHeight());
		
		//draw gui
		
	    //draw game 
		if (State == STATE.GAME){
		
		g2d.translate(cam.getx(), cam.gety());//begin of cam
		handler.render(g);
		
		//Blackadder ITC
		g.setFont(new Font("Chiller",Font.BOLD,100));
		g.setColor(Color.RED);
		g.drawString("T H E  E S C A P E  R O O M", -5, -2);
		
				
		g2d.translate(-cam.getx(), -cam.gety());//end of cam
		
		//100 100
		g.drawString(handler.getGameTime(), 0, 70);
		
		String hearts = "";
		for(int i = 0; i < handler.object.size(); i++)
		{
			  Gameobject tempObject = handler.object.get(i);
			  if (tempObject.getId() == Objectid.player)
			  {
				  switch(handler.getHeartCount()){
				 	case 1: hearts = "❤                  "; break;
				 	case 2: hearts = "❤ ❤              "; break;
				 	case 3: hearts = "❤ ❤ ❤         "; break;
				 	case 4: hearts = "❤ ❤ ❤ ❤     "; break;
				 	case 5: hearts = "❤ ❤ ❤ ❤ ❤"; break;
				 	default: hearts = ""; break;
				 }
			  }
		 }
		
		g.setFont(new Font("Comic Sans",Font.BOLD,100));
		g.drawString(hearts, getWidth()-650, 100);
		
		if(handler.heartCount == 0){
			handler.clearlevel();
			State = STATE.DEATH;
		}
		
		}else if (State == STATE.MENU){
		won = false;
		Game.Level = 1;
		handler.resetHearts();
        g2d.translate(cam.getx(), cam.gety());//begin of cam
		cam.setx(0);
        cam.sety(0);
		menu.render(g);
		
		g2d.translate(-cam.getx(), -cam.gety());//end of cam

		}else if(State == STATE.WINMESSAGE){
			WinMessage message = new WinMessage(handler.getTimer());
			message.render(g);
		}else if(State == STATE.HELP){
			HelpMessage message = new HelpMessage();
			message.render(g);
		}else if(State == STATE.DEATH){
			handler.timer.resetGameTime();
			DeathMessage message = new DeathMessage();
			message.render(g);
		}
		
		////////////////////////////////////////////////////
		g.dispose();
		bs.show();
	}
	
	
	/*
	 * Class for managing the key inputs
	 */
	public class keyinput extends KeyAdapter
	{
		Handler handler;
		
		/*
		 * Constructs a keyinput object
		 */
		public keyinput(Handler handler){
			this.handler = handler;
		}
	 
		/*
		 * Moves objects based on key presses
		 * @param e the key pressed by the user
		 */
		public void keyPressed(KeyEvent e){
		 int key = e.getKeyCode();
		
		 if(key == KeyEvent.VK_0) State = STATE.WINMESSAGE;
		 
		 if (State == State.GAME){
				 
		 for(int i = 0; i < handler.object.size(); i++)
		 {
			  Gameobject tempObject = handler.object.get(i);
			  
			  if (tempObject.getId() == Objectid.player)
			  {
				  if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) tempObject.setvelx(5);
				  if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) tempObject.setvelx(-5);
				  if((key == KeyEvent.VK_SPACE || key == KeyEvent.VK_UP || key == KeyEvent.VK_W)&& !tempObject.isJumping()) 
				  {
					  tempObject.setJumping(true);
					  tempObject.setvely(-15);
				  }
			  }
		 }
		 if(key == KeyEvent.VK_ESCAPE){
			 Game.State = Game.STATE.MENU; cam.setx(0); 
			 handler.resetTimer();
		 }
		 }
		
		}
		
		/*
		 * Moves objects based on key releases
		 * @param e the key released by the user
		 */
	    public void keyReleased(KeyEvent e){
	    	 int key = e.getKeyCode();
	    	 
	    	 for(int i = 0; i < handler.object.size(); i++)
	    	 {
	    		  Gameobject tempObject = handler.object.get(i);
	    		  
	    		  if (tempObject.getId() == Objectid.player)
	    		  {
	    			  if(key == KeyEvent.VK_D) tempObject.setvelx(0);
	    			  if(key == KeyEvent.VK_A) tempObject.setvelx(0);
	    			  if(key == KeyEvent.VK_LEFT) tempObject.setvelx(0);
	    			  if(key == KeyEvent.VK_RIGHT) tempObject.setvelx(0);
	    		  }
	    	 }
		}
	}
	
	/*
	 * Gets the texture of the object
	 * @return tex the texture of the object
	 */
	public static Texture getInstance(){
		return tex;
	}
	
	/*
	 * Gets the number of snow on the screen
	 * @return snow_count the number of snow on the screen
	 */
	public int getSnow_count() {
		return snow_count;
	}
	/*
	 * Sets the number of snow on the screen
	 * @param snow_count the number of snow set
	 */
	public void setSnow_count(int snow_count) {
		this.snow_count = snow_count;
	}

}

