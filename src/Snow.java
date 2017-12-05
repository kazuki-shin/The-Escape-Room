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
//This class creates snow used soley for decoration
public class Snow extends Gameobject{
	private float gravity = 0.5f;
	
	Random r =new Random();
	private final float MAX_SPEED = (float) (r.nextInt((int) 2.5)+1);
	/*
	 * Constructs a snow object
	 * @param x the x coordinate of the snow
	 * @param y the y coordinate of the snow
	 * @param id the id of the snow
	 */
	public Snow(float x, float y, Objectid id) {
		super(x, y, id);
	}

	/*
	 * Updates the game logic for snow
	 * @param object holds all objects of the game in this linked list
	 */
	public void tick(LinkedList<Gameobject> object) {
		y += vely;
		x += velx;
		
		if(falling || jumping)
		{
		     vely += gravity;
		     
		     if(vely > MAX_SPEED){
		    	 vely=MAX_SPEED;
		     }
		     if(y > Game.HEIGHT){
		    	 x =  x = r.nextInt(Game.WIDTH);
		    	 y = 0;
		     }
		}
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int)x+16,(int) y, 8, 8);
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x,(int)y,8,8);
	}

}