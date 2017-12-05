/*
 * Kazuki Shin
 * 2nd Period
 * 5/21/17
 * Gallatin
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Random;
//Class for the flag which is the final destination/goal of the maze
public class Flag extends Gameobject{

	Random r = new Random();
	
	/*
	 * Constructor for Flag object
	 * @param x the x coordinate of the flag
	 * @param y the y coordinate of the flag
	 * @param id the object id of the flag
	 */
	public Flag(float x, float y, Objectid id) {
		super(x, y, id);
		
	}

	/*
	 * Updates the game logic for flag
	 * @param object holds all objects of the game in this linked list
	 */
	public void tick(LinkedList<Gameobject> object) 
	{
		
	}

	/*
	 * Updates the flag graphics on the screen 
	 * @param g the Graphics used to updates the flag
	 */
	public void render(Graphics g) 
	{
	   g.setColor(new Color(r.nextInt()+255));
	   g.fillRect((int)x,(int) y, 32, 32);
	}

	/*
	 * returns the boundaries of the flag
	 * @return the boundary of the flag
	 */
	public Rectangle getBounds() {
	return new Rectangle((int)x,(int)y,32,32);
	}
}

