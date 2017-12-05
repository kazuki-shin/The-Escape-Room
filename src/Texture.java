/*
 * Kazuki Shin
 * 2nd Period
 * 5/21/17
 * Gallatin
 */
import java.awt.image.BufferedImage;

//This class connects the cropped images to the objects
public class Texture {

	SpriteSheet ss;
	SpriteSheet ds;
	SpriteSheet ks;
	private BufferedImage spike = null;
	private BufferedImage door = null;
	private BufferedImage key = null;
	
	public BufferedImage[] Spike = new BufferedImage[1];
	public BufferedImage[] Door = new BufferedImage[1];
	public BufferedImage[] Key = new BufferedImage[1];
	/*
	 * Constructs a texture object
	 */
	public Texture(){
		BufferedImageLoader loader = new BufferedImageLoader(); 
		try{
			spike = loader.loadImage("/spikes.png");
			door = loader.loadImage("/door.png");
			key = loader.loadImage("/key.png");
		}catch(Exception e){
			e.printStackTrace();
		}
		ss = new SpriteSheet(spike);
		ds = new SpriteSheet(door);
		ks = new SpriteSheet(key);
		getTextures();
	}

	/*
	 * Matche the textures with its corresponding object
	 */
	private void getTextures() {
		
		Spike[0] = ss.grabImage(32, 32);
		Door[0] = ds.grabImage(32, 32);
		Key[0] = ks.grabImage(32, 32);
	}
	
}