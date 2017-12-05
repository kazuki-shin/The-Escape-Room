/*
 * Kazuki Shin
 * 2nd Period
 * 5/21/17
 * Gallatin
 */

import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Arrays;
import java.util.Date;
import java.util.TreeMap;
import java.util.ArrayList;
/**
   This component displays the Game Timer
*/
public class GameTimer implements ActionListener
{
	private static final long serialVersionUID = -870785256208743017L;
	private Timer time; 
	private int secCount; 
	
	/*
	 * Constructs a Game Timer Object
	 */
	public GameTimer()
	{	
		secCount = 300; 
		time = new Timer(1000, this);
	}
	
	/*
	 * Starts the game timer
	 */
	public void startGameTime(){
		time.start(); 
	}
	
	/*
	 * Rests the game timer to 5 min
	 */
	public void resetGameTime(){
		secCount = 300;
		time.stop();
	}
	/*
	 * Stops the game timer
	 */
	public void stopGameTime(){
		
		time.stop();
	}
	/*
	 * returns the time remaining
	 * @return the time remaining in minutes
	 */
	public String getGameTime(){
		int min = secCount/60; 
		int sec = secCount%60;
		String sMin = min + ""; 
		String sSec = sec + ""; 
		
		if(sMin.length() == 1)
			sMin = "0" + sMin; 
		
		if(sSec.length() == 1)
			sSec = "0" + sSec; 
				
		return sMin+ ":" + sSec;
	}

	/*
	 * Updates the GameTimer object every 1000 mil
	 * @param e the actionEvent
	 */
	public void actionPerformed(ActionEvent e) {
		secCount--;
		if(secCount<=0)
			Game.State = Game.STATE.DEATH;
	}
	
	/*
	 * Returns the amount of seconds left in the game
	 * @return secCount the amount of seconds left in the game
	 */
	public int getSecCount(){
		return secCount;
	}

}