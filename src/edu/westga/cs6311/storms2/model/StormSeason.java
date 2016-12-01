package edu.westga.cs6311.storms2.model;

import java.util.ArrayList;

/**
 * Models an object that manages a season of
 * 	hurricanes
 * @author BrandonWilliams
 * @version 11/9/16
 */
public class StormSeason {
	private ArrayList<Hurricane> theStorms;
	
	/**
	 * Constructor to create the StormSeason object
	 */
	public StormSeason() {
		this.theStorms = new ArrayList<Hurricane>();
	}
	
	/**
	 * Adds the specified Hurricane to the StormSeason
	 * 
	 * @param	newHurricane	The Hurricane to be added
	 * @precondition			newHurricane != null
	 */
	public void addHurricane(Hurricane newHurricane) {	
		if (newHurricane == null) {
			return;
		} else {
			this.theStorms.add(newHurricane);
		}
	}
	
	/**
	 * Finds and returns the first Hurricane that matches 
	 * 	the specified name
	 * 
	 * @param	searchName		The name to be searched for
	 * @precondition			searchName != null
	 * @return					Found Hurricane object or null if not found
	 */
	public Hurricane findHurricane(String searchName) {
		if (searchName == null) {
			return null;
		}
		
		for (Hurricane current : this.theStorms) {
			if (current.getName().equalsIgnoreCase(searchName)) {
				return current;
			}
		}
		
		return null;
	}
	
	/**
	 * Removes the hurricane specified from the collection
	 * 
	 * @param	removedHurricane	The Hurricane to be removed
	 * @precondition				removedHurricane != null
	 */
	public void removeHurricane(Hurricane removedHurricane) {
		if (removedHurricane == null) {
			return;
		} else {
			this.theStorms.remove(removedHurricane);
		}
	}
	
	/**
	 * Sets the wind speed of the specified Hurricane to the new speed
	 * 
	 * @param	updatedHurricane	The Hurricane to be updated
	 * @param	newSpeed			The new wind speed to be updated
	 * @precondition				name != null
	 * 								newSpeed >= 74
	 */
	public void updateHurricane(Hurricane updatedHurricane, int newSpeed) {
		if (updatedHurricane == null) {
			return;
		} else {
			updatedHurricane.setWindSpeed(newSpeed);
		}
	}
	
	/**
	 * Builds and returns an output string of the season
	 * 
	 * @return	A string representation of the season
	 */
	public String toString() {
		if (this.theStorms.isEmpty()) {
			return "There are no hurricanes present";
		}
		String result = "Hurricane Season Information:\n";
		
		for (Hurricane current : this.theStorms) {
			result += current.toString() + "\n";
		}
		
		result += "\nMinimum speed: " + this.getMinimumSpeed() + "\n";
		result += "Maximum speed: " + this.getMaximumSpeed() + "\n";
		result += String.format("Average speed: %.2f\n", this.getAverageSpeed());
		
		return result;
	}
	
	/**
	 * Builds and returns a summary of the category breakdown (number of
	 * 	Category 1's, 2's, etc)
	 * 
	 * @return	The category breakdown
	 */
	public String getCategoryBreakdown() {
		int [] gradingBreakdown = this.calcualteCategoryBreakdown();
		
		String categoryOutput;
		categoryOutput = "Category 1: " + gradingBreakdown[0] + "\n";
		categoryOutput += "Category 2: " + gradingBreakdown[1] + "\n";
		categoryOutput += "Category 3: " + gradingBreakdown[2] + "\n";
		categoryOutput += "Category 4: " + gradingBreakdown[3] + "\n";
		categoryOutput += "Category 5: " + gradingBreakdown[4] + "\n";
		
		return categoryOutput;
	}
	
	/**
	 * Builds and returns a histogram of the category breakdown (number of
	 * 	Category 1's, 2's, etc)
	 * 
	 * @return	The category histogram
	 */
	public String getCategoryHistogram() {
		int [] gradingBreakdown = this.calcualteCategoryBreakdown();
		
		String histogram;
		histogram = "Category 1: " + this.starLine(gradingBreakdown[0]) + "\n";
		histogram += "Category 2: " + this.starLine(gradingBreakdown[1]) + "\n";
		histogram += "Category 3: " + this.starLine(gradingBreakdown[2]) + "\n";
		histogram += "Category 4: " + this.starLine(gradingBreakdown[3]) + "\n";
		histogram += "Category 5: " + this.starLine(gradingBreakdown[4]) + "\n";
		
		return histogram;
	}
	
	private int getMinimumSpeed() {
		int minimumSoFar = Integer.MAX_VALUE;
		
		for (Hurricane current : this.theStorms) {
			if (current.getWindSpeed() < minimumSoFar) {
				minimumSoFar = current.getWindSpeed();
			}
		}
		
		return minimumSoFar;
	}
	
	private int getMaximumSpeed() {
		int maximumSoFar = Integer.MIN_VALUE;
		
		for (Hurricane current : this.theStorms) {
			if (current.getWindSpeed() > maximumSoFar) {
				maximumSoFar = current.getWindSpeed();
			}
		}
		
		return maximumSoFar;
	}
	
	private double getAverageSpeed() {
		double sum = 0.0;
		
		for (Hurricane current : this.theStorms) {
			sum += current.getWindSpeed();
		}
		
		return sum / this.theStorms.size();
	}
	
	private int [] calcualteCategoryBreakdown() {
		int [] results = new int[5];
		
		for (Hurricane current : this.theStorms) {
			int speed = current.getWindSpeed();
			
			if (speed <= 95) {
				results[0]++;
			} else if (speed <= 110) {
				results[1]++;
			} else if (speed <= 129) {
				results[2]++;
			} else if (speed < 156) {
				results[3]++;
			} else {
				results[4]++;
			}
		}
		
		return results;
	}
	
	private String starLine(int number) {
		String result = "";
		
		for (int count = 0; count < number; count++) {
			result += "*";
		}
		
		return result;
	}
}
