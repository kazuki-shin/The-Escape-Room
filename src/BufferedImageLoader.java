/*
 * Kazuki Shin
 * 2nd Period
 * 5/21/17
 * Gallatin
 */

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

//Class used to help load images from a specified path
public class BufferedImageLoader {
	
	private BufferedImage image;
	
	/*
	 * Loads the image onto the graphics window
	 * @param path the path which the image is located
	 */
	public BufferedImage loadImage(String path){
		try{
		//image =ImageIO.read(getClass().getResource(path)); //Resource Folder
		//image =ImageIO.read(new File("H:\\Desktop\\GameImages"+path)); //School
		image =ImageIO.read(new File("C:\\Users\\Kazuki\\Desktop\\GameImages"+path)); //XPS
		//image =ImageIO.read(new File("C:\\Users\\Kazuki Shin\\Desktop\\GameImages"+path)); //Desktop
		}  catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}

}
