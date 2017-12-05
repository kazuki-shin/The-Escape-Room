/*
 * Kazuki Shin
 * 2nd Period
 * 5/21/17
 * Gallatin
 */
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
//Class for keeping the high scores
public class TopScores {
	
	TreeSet<String> set;
	/*
	 * constructs a topscore object
	 */
	public TopScores(){
		set = new TreeSet<String>();
	}
	/*
	 * adds a score to the set
	 * @param time the score being added
	 */
	public void addScore(String time){
		set.add(time);
	}
	/*
	 * returns the rank in which the player is in
	 * @return the rank of the player
	 */
	public int getRank(String time){
		int count = 1;
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			if(it.next().equals(time))
				return count;
			count++;
		}
		return -1;
	}
	/*
	 * returns the objects contained in the list as strings
	 * @return s the objects in the list as a string
	 */
	public String toString(){
		String s = "";
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
		    s += it.next() + "\n";
		}
		return s;
	}
}
