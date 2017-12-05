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

//This class creates a block object used to create the course of the game
public class Block extends Gameobject{
	Random rand = new Random();
	int color = rand.nextInt(4);

	/*
	 * Constructs a block object
	 * @param x the x coordinate of the block
	 * @param y the y coordinate of the block
	 * @param id the id of the block
	 */
	public Block(float x, float y, Objectid id) {
		super(x, y, id);
		
	}

	/*
	 * Updates the game logic for block
	 * @param object holds all objects of the game in this linked list
	 */
	public void tick(LinkedList<Gameobject> object) 
	{
		
	}

	/*
	 * Updates the block graphics on the screen 
	 * @param g the Graphics used to updates the blocks
	 */
	public void render(Graphics g) 
	{
	   if (color == 0){
	   g.setColor(Color.blue);
	   g.drawRect((int)x,(int) y, 32, 32);
	   }else if (color == 1){
		   g.setColor(Color.red);
		   g.drawRect((int)x,(int) y, 32, 32);
	   }else if (color == 2){
		   g.setColor(Color.orange);
		   g.drawRect((int)x,(int) y, 32, 32);
	   }
	   else if (color == 3){
		   g.setColor(Color.yellow);
		   g.drawRect((int)x,(int) y, 32, 32);
	   }
	   
	   
	}

	/*
	 * returns the boundaries of the block
	 * @return the boundary of the block
	 */
	public Rectangle getBounds() {
	return new Rectangle((int)x,(int)y,32,32);
	}
}

