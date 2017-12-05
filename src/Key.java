/*
 * Kazuki Shin
 * 2nd Period
 * 5/21/17
 * Gallatin
 */
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
//This class creates a key object used to open doors
public class Key extends Gameobject{
	Texture tex = Game.getInstance();
	
	/*
	 * Constructs a key object
	 * @param x the x coordinate of the key
	 * @param y the y coordinate of the key
	 * @param id the id of the key
	 */
	public Key(float x, float y, Objectid id) {
		super(x, y, id);
	}
	/*
	 * Updates the game logic for key
	 * @param object holds all objects of the game in this linked list
	 */
	public void tick(LinkedList<Gameobject> object) {
		
	}
	/*
	 * Updates the key graphics on the screen 
	 * @param g the Graphics used to updates the key
	 */
	public void render(Graphics g) {
		g.drawImage(tex.Key[0], (int)x,(int) y, null);
	}
	/*
	 * returns the boundaries of the key
	 * @return the boundary of the key
	 */
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,32,32);
	}

}

