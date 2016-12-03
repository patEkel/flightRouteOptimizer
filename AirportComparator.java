package assignment13;

import java.util.Comparator;

public class AirportComparator implements Comparator<Airport>{

	@Override
	public int compare(Airport arg0, Airport arg1) {
		if (arg0.currentBest < arg1.currentBest){
			return -1;
		}
		if (arg0.currentBest > arg1.currentBest){
		return 1;
	}
return 1;
	}
}
