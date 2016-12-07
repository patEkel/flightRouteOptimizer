/**
 * 
 */
package assignment13;

import java.util.ArrayList;

/**
 * This class is what we will test your code on. If your BestPath
 * objects equal ours (using the .equals method given) then you will
 * pass the tests. Do no modify anything that is given (use it of
 * course but don't change names etc.)
 * 
 * @author CS2420 Teaching Staff - Spring 2016
 * Kyle Price and Patrick Ekel 
 * 12/6/2016
 */
public class BestPath {
	
	/**
	 * This should contain the nodes between the origin and destination
	 * inclusive. For example if I want the path between SLC and MEM it
	 * should have SLC (index 0), MEM (index 1). If there are lay overs
	 * it should include them in between (turns out you can fly to Memphis
	 * from here directly).
	 */
	public ArrayList<String> path;
	
	/**
	 * Since some path costs are going to be doubles sometimes use a double
	 * when costs are integers cast to a double.
	 */
	public double pathLength;

	@Override
	public boolean equals(Object o) {
		if (o instanceof BestPath) {
			BestPath other = (BestPath) o;
			return this.pathLength == other.pathLength && this.path.equals(other.path);
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Path Length: " + pathLength + "\nPath: "+ this.path;
	}
}
