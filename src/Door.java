/*
 * Kazuki Shin
 * 2nd Period
 * 5/21/17
 * Gallatin
 */
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

//Class for the door which, without the key, prevents player from moving further into maze
public class Door extends Gameobject{
	Texture tex = Game.getInstance();
	
	/*
	 * Constructor for Door object
	 * @param x the x coordinate of the door
	 * @param y the y coordinate of the door
	 * @param id the object id of the door
	 */
	public Door(float x, float y, Objectid id) {
		super(x, y, id);
		
	}
	/*
	 * Updates the game logic for door
	 * @param object holds all objects of the game in this linked list
	 */
	public void tick(LinkedList<Gameobject> object) {
		
		
	}

	/*
	 * Updates the door graphics on the screen 
	 * @param g the Graphics used to updates the door
	 */
	public void render(Graphics g) {
		g.drawImage(tex.Door[0], (int)x,(int) y, null);;
	}

	/*
	 * returns the boundaries of the door
	 * @return the boundary of the door
	 */
	public Rectangle getBounds() {
		
		return new Rectangle((int)x,(int)y,32,32);
	}

}
