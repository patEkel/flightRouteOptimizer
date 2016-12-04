package assignment13;

import java.util.Comparator;

public class AirportComparator implements Comparator<Airport> {

	@Override
	public int compare(Airport o1, Airport o2) { 
		if (o1.currentBest > o2.currentBest) {
			return 1;
		}
		if (o1.currentBest < o2.currentBest) {
			return -1;
		}
		return 0;
	}
}
