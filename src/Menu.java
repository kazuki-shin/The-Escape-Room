/*
 * Kazuki Shin
 * 2nd Period
 * 5/21/17
 * Gallatin
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

//Class which displays the game menu
public class Menu {
	
	Handler handler ;
	Camera cam;

	public Rectangle playButton = new Rectangle(Game.WIDTH / 2 +300, 150, 100, 50);
	public Rectangle helpButton = new Rectangle(Game.WIDTH / 2 +300, 250, 100, 50);
	public Rectangle quitButton = new Rectangle(Game.WIDTH / 2 +300, 350, 100, 50);
	/*
	 * Updates the menu graphics on the screen 
	 * @param g the Graphics used to updates the menu
	 */
	public void render(Graphics g){
		cam = new Camera(0, 0);
		handler = new Handler(cam);
		Graphics2D g2d = (Graphics2D) g;
		Font fnt0 = new Font("Chiller", Font.BOLD, 400);
		g.setFont(fnt0);
		g.setColor(Color.RED);
		g.drawString("THE", 10 , 300);
		g.drawString("ESCAPE", 10 , 650);
		g.drawString("ROOM", 10 , 1000);
		
		
		g.setColor(Color.RED);
		g2d.fill(playButton);
		g2d.fill(helpButton);
		g2d.fill(quitButton);
		
		
		Font fnt1 =new Font("Chiller", Font.BOLD, 40);
		g.setFont(fnt1);
		g.setColor(Color.BLACK);
		g.drawString("PLAY", playButton.x + 19-7, playButton.y + 30+7);
		g.setColor(Color.BLACK);
		g.drawString("HELP", helpButton.x + 19-7, helpButton.y + 30+7);
		g.setColor(Color.BLACK);
		g.drawString("QUIT", quitButton.x + 19-7, quitButton.y + 30+7);
		g.setColor(Color.white);
		
	}
	
}
