/*
 * Kazuki Shin
 * 2nd Period
 * 5/21/17
 * Gallatin
 */
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
//This class creates the game's GUI
public class Window 
{
	Handler handler;
	Camera cam;
	
	private BufferedImage level_2 = null, level = null;

	/*
	 * Constructs a window object
	 * @param w the width of the frame
	 * @param h the height of the frame
	 * @title the title of the frame
	 * @game the game beign started in the frame
	 */
	public Window (int w,int h,String title, Game game)
	{
		
		handler = new Handler(cam);
		BufferedImageLoader loader = new BufferedImageLoader();
	    level_2 = loader.loadImage("/level_2.png");
	    level = loader.loadImage("/level_1.png");
		game.setPreferredSize(new Dimension(w,h));
		game.setMaximumSize(new Dimension(w,h));
		game.setMinimumSize(new Dimension(w,h));
		
		JFrame frame = new JFrame(title);
		
		frame.add(game);
		frame.setUndecorated(true);
		frame.pack();
		
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		game.start();
	}

}
