/*
 * Kazuki Shin
 * 2nd Period
 * 5/21/17
 * Gallatin
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;

//Class which displays the message after the player loses game
public class DeathMessage {
	public Rectangle backButton = new Rectangle(Game.WIDTH / 2 -100, 1000, 110, 50);
	
	/*
	 * Updates the message graphics on the screen 
	 * @param g the Graphics used to updates the message
	 * 
	 */
	public void render(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		g.setColor(Color.black);
		g.fillRect(0, 0, (int)screenSize.getWidth(), (int)screenSize.getHeight());
		Font fnt0 = new Font("Chiller", Font.BOLD, 170);
		g.setFont(fnt0);
		g.setColor(Color.RED);
		g.drawString("UNLUCKY... YOU COULDN'T", 10 , 150);
		g.drawString("ESCAPE. U R NOW DEAD. ", 10 , 350);
		g.drawString("TRY FINISHING FASTER", 10 , 550);
		g.drawString("OR NOT HITTING THE ", 10 , 750);
		g.drawString("SPIKES NEXT TIME ;)", 10 , 950);
		
		g.setColor(Color.RED);
		g2d.fill(backButton);
		
		Font fnt1 =new Font("Chiller", Font.BOLD, 40);
		g.setFont(fnt1);
		g.setColor(Color.BLACK);
		g.drawString("BACK", backButton.x + 19-7, backButton.y + 30+7);
		
	}
	
}
