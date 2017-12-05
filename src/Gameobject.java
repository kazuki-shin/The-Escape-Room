
/*
 * Kazuki Shin
 * 2nd Period
 * 5/21/17
 * Gallatin
 */
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

//Base class for all objects in the game
public abstract class Gameobject 
{
	
	
	public float x;
	public float y;
	protected Objectid id;
	protected float velx = 0, vely = 0;
	protected boolean falling = true;
	protected boolean jumping = false;
	
	/*
	 * Constructs a Game Object
	 * @param x the x coordinate of the Game Object
	 * @param y the y coordinate of the Game Object
	 * @param id the object id of the Game Object
	 */	public Gameobject(float x, float y, Objectid id)
	{
		this.x = x;
		this.y = y;
		this.id = id;
	}
	/*
	 * Updates the game logic for game object
	 * @param object holds all objects of the game in this linked list
	 */
	public abstract void tick(LinkedList<Gameobject> object);
	/*
	 * Updates the game object's graphics on the screen 
	 * @param g the Graphics used to updates the game object
	 */
	public abstract void render(Graphics g);
	/*
	 * returns the boundaries of the game object
	 * @return the boundary of the game object
	 */
	public abstract Rectangle getBounds();
	
	/*
	 * returns the x coordinate of the game object
	 * @return x the x coordinate of the game object
	 */
	public float getx(){
		return x;
		
	}
	/*
	 * returns the y coordinate of the game object
	 * @return y the y coordinate of the game object
	 */
	public float gety(){
		return y;
		
	}
	/*
	 * sets the x coordinate of the game object
	 * @param x the x coordinate being set
	 */
	public void setx(float x){
		this.x = x;
	}
	/*
	 * sets the y coordinate of the game object
	 * @param y the y coordinate being set
	 */
	public void sety(float y){
		this.y = y;
	}
	/*
	 * returns the x velocity of the game object
	 * @return velx the x velocity of the game object
	 */
	public float getvelx(){
		return velx;
	}
	/*
	 * returns the y velocity of the game object
	 * @return vely the y velocity of the game object
	 */
	public float getvely(){
		return vely;
		
	}
	/*
	 * sets the x velocity of the game object
	 * @param velx the x velocity being set
	 */
	public void setvelx(float velx){
		this.velx = velx;
	}
	/*
	 * sets the y velocity of the game object
	 * @param vely the y velocity being set
	 */
	public void setvely(float vely){
		this.vely = vely;
	}
	/*
	 * returns the id of the game object
	 * @return id the id of the game object
	 */
	public Objectid getId(){
		return id;
	}
	/*
	 * returns if the object is falling or not
	 * @return falling true if the object is falling
	 */
	public boolean isFalling() {
		return falling;
	}

	/*
	 * sets falling to true if object is falling
	 * @param falling true if the object is falling
	 */
	public void setFalling(boolean falling) {
		this.falling = falling;
	}
	/*
	 * returns if the object is jumping or not
	 * @return jumping true if the object is jumping
	 */
	public boolean isJumping() {
		return jumping;
	}
	/*
	 * sets jumping to true if object is jumping
	 * @param jumping true if the object is jumping
	 */
	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}

}
