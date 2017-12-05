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
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
//class which displays the winning message
public class WinMessage {
	
	private int secLeft;
	private TopScores scores;
	/*
	 * Constructs a winMessage object
	 * @param timer the Game timer
	 */
	public WinMessage(GameTimer timer){
		timer.stopGameTime();
		this.secLeft = timer.getSecCount();
		scores = new TopScores();
		this.readFileTimes();
	}
	
	public Rectangle quitButton = new Rectangle(Game.WIDTH / 2 -100, 1000, 110, 50);
	/*
	 * Updates the message graphics on the screen 
	 * @param g the Graphics used to updates the message
	 */
	public void render(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		g.setColor(Color.black);
		g.fillRect(0, 0, (int)screenSize.getWidth(), (int)screenSize.getHeight());
		Font fnt0 = new Font("Chiller", Font.BOLD, 170);
		g.setFont(fnt0);
		g.setColor(Color.RED);
		g.drawString("CONGRATS! YOU ESCAPED", 10 , 200);
		g.drawString("WITH A TIME OF "+ calcScore(), 10 , 400);
		g.drawString("YOU'RE STILL WORSE", 10 , 600);
		g.drawString("THAN "+(getRank()-1)+" PEOPLE THO :/", 10 , 800);
		
		g.setColor(Color.RED);
		g2d.fill(quitButton);
		
		Font fnt1 =new Font("Chiller", Font.BOLD, 40);
		g.setFont(fnt1);
		g.setColor(Color.BLACK);
		g.drawString("QUIT", quitButton.x + 19-7, quitButton.y + 30+7);
	}
	/*
	 * gets the players rank
	 * @return the players rank
	 */
	private int getRank(){
		return scores.getRank(calcScore());
	}
	  /*
	   * reads in all the previous scores from text files and adds the new score into the list
	   */
	private void readFileTimes(){
		Path path = Paths.get("C:\\Users\\Kazuki\\Desktop\\GameImages\\read.txt"); //XPS
		//Path path = Paths.get("H:\\Desktop\\GameImages\\read.txt"); //School
		//Path path = Paths.get("C:\\Users\\Kazuki Shin\\Desktop\\GameImages\\read.txt"); //Desktop
	    try {
			List<String> list =  Files.readAllLines(path, StandardCharsets.UTF_8);
			for(String e: list)
				scores.addScore(e);
			 scores.addScore(calcScore());
			 if(list.indexOf(calcScore())==-1)
				 list.add(calcScore());
			 Files.write(path, list, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Calculates the score of the player
	 */
	private String calcScore(){
		int timeLeft = 300 - secLeft;
		int min = timeLeft/60; 
		int sec = timeLeft%60;
		String sMin = min + ""; 
		String sSec = sec + ""; 
		
		if(sMin.length() == 1)
			sMin = "0" + sMin; 
		
		if(sSec.length() == 1)
			sSec = "0" + sSec; 
				
		return sMin + "min "+ sSec+ "sec";
	}
}
