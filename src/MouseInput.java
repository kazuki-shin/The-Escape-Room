/*
 * Kazuki Shin
 * 2nd Period
 * 5/21/17
 * Gallatin
 */
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.image.BufferedImage;
//Class for managing actions from mouse inputs
public class MouseInput implements MouseListener {
	
	private BufferedImage level2 = null, level = null;
	
	private static MouseEvent mouseClicked;
	private static MouseEvent mousePressed;
	private static MouseEvent mouseReleased;
	private static MouseEvent mouseMoved;
	private static MouseEvent mouseDragged;
	private static MouseEvent mouseEntered;
	private static MouseEvent mouseExited;
	private static MouseWheelEvent mouseWheelMoved;
	Handler handler;
	Camera cam;
	
	/*
	 * sets mouseclicked to the most recent event
	 * @param e the most recent event
	 */
	public void mouseClicked(MouseEvent e) {
		mouseClicked = e;
	}
	
	/*
	 *Manages the actions for when the mouse is pressed
	 *@param e the most recent event
	 */
	public void mousePressed(MouseEvent e) {
		BufferedImageLoader loader = new BufferedImageLoader();
	   
		cam = new Camera(0,0);
	handler = new Handler(cam);	
	
    if(Game.State == Game.State.MENU){
		int mx = e.getX();
		int my = e.getY();
		 
		if (mx >= Game.WIDTH / 2 +300 && mx <= Game.WIDTH / 2 + 100+300)
		{
		    if(my >= 150 && my <= 200)
		    {
		    	//Game.State = Game.State.levelsel;
		    	Game.State = Game.STATE.GAME;
  		    	Game.llevel1 = 1;
  		    	handler.Level = 1;
		   
		    }
		}
		 
		if (mx >= Game.WIDTH / 2 +300 && mx <= Game.WIDTH / 2 + 100+300)
		{
		    if(my >= 250 && my <= 300)
		    {
		    	Game.State = Game.STATE.HELP;
		    }
		}
		
		if (mx >= Game.WIDTH / 2 +300 && mx <= Game.WIDTH / 2 + 100+300)
		{
		    if(my >= 350 && my <= 400)
		    {
		    	System.exit(1);
		    }
		}
    }else 
    if(Game.State == Game.State.HELP || Game.State == Game.State.DEATH){
    	int mx = e.getX();
		int my = e.getY();
    	if (mx >= Game.WIDTH / 2 -100 && mx <= Game.WIDTH / 2 +10)
		{
		    if(my >= 1000 && my <= 1050)
		    {
		    	Game.State = Game.STATE.MENU;
		    }
		}
    }else 
    if(Game.State == Game.State.WINMESSAGE){
    	int mx = e.getX();
    	int my = e.getY();
       	if (mx >= Game.WIDTH / 2 -100 && mx <= Game.WIDTH / 2 +10)
    	{
    	    if(my >= 1000 && my <= 1050)
    	    {
    	    	System.exit(1);
    	    }
    	}
    }
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		mouseReleased = e;
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		mouseEntered = e;
	}
	@Override
	public void mouseExited(MouseEvent e) {
		mouseExited = e;
	}
	
}