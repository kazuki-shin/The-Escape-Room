/*
 * Kazuki Shin
 * 2nd Period
 * 5/21/17
 * Gallatin
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Random;

//This class creates a spike used for hindering the players escape
public class Spike extends Gameobject{
	Texture tex = Game.getInstance();
	Random rand = new Random();
	int color = rand.nextInt(4);
	private Handler handler;
	private Camera cam;
	private BufferedImage level2 = null, level = null,level3 = null,level4 = null;
	
	/*
	 * Constructs a spike object
	 * @param x the x coordinate of the spike
	 * @param y the y coordinate of the spike
	 * @param id the id of the spike
	 */
	public Spike(float x, float y,Objectid id) {
		super(x, y, id);
		
	}

	/*
	 * Updates the game logic for snow
	 * @param object holds all objects of the game in this linked list
	 */
	public void tick(LinkedList<Gameobject> object) 
	{
		
	}


	/*
	 * Updates the snow graphics on the screen 
	 * @param g the Graphics used to updates the snow
	 */
	public void render(Graphics g) 
	{
		g.drawImage(tex.Spike[0], (int)x,(int) y, null);
	}

	/*
	 * returns the boundaries of the snow
	 * @return the boundary of the snow
	 */
	public Rectangle getBounds() {
	return new Rectangle((int)x,(int)y,32,32);
	}
}
