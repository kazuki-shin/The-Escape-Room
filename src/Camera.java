/*
 * Kazuki Shin
 * 2nd Period
 * 5/21/17
 * Gallatin
 */

//This class allows the map to pan around the screen keeping the player in the middle of the screen/ visible at all times
public class Camera{

	float x;
	float y;
	
	/*
	 * Constructs a Camera Object
	 * @param x starting x coordinate for the camera
	 * @param y starting y coordinate for the camera
	 */
	public Camera(float x, float y){
		this.x = x;
		this.y = y;
	}
	/*
	 * Updates the game logic for Camera
	 * @param player the object which the camera pivots around
	 */
	public void tick(Gameobject player){
		x = -player.getx() + Game.WIDTH/2;
		y = -player.gety() + Game.HEIGHT/2-100;
	}
	/*
	 * Sets the x coordinate of the camera
	 * @param x the x coordinate being set
	 */
	public void setx(float x){
		this.x = x;
	}
	/*
	 * Sets the y coordinate of the camera
	 * @param y the y coordinate being set
	 */
	public void sety(float y){
		this.y = y;
	}
	/*
	 * Gets the x coordinate of the Camera
	 * @return x the x coordinate of the Camera
	 */
	public float getx(){
		return x;
	}
	/*
	 * Gets the y coordinate of the Camera
	 * @return y the y coordinate of the Camera
	 */
	public float gety(){
		return y;
	}
	
}
