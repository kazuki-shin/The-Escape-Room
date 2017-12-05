/*
 * Kazuki Shin
 * 2nd Period
 * 5/21/17
 * Gallatin
 */
import java.awt.image.BufferedImage;
//Holds image for objects
public class SpriteSheet {

	private BufferedImage image;
	/*
	 * Constructs a spriteSheet object
	 * @param image the image for the object
	 */
	public SpriteSheet(BufferedImage image){
		this.image = image;
	}
	/*
	 * gets a cropped image of the specified image
	 * @param width the width to crop to
	 * @param height the height to crop to
	 */
	public BufferedImage grabImage(int width, int height){
		BufferedImage img = image.getSubimage(0, 0, width, height);
		return img;
	}
	
}