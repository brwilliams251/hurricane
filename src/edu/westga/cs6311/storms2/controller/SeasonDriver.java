/**
 * 
 */
package edu.westga.cs6311.storms2.controller;
import edu.westga.cs6311.storms2.model.StormSeason;
import edu.westga.cs6311.storms2.view.SeasonTUI;

/**
 * This class creates a StormSeason object to run the methods in the
 * StormSeason class
 * 
 * @author BrandonWilliams
 * @version 11/9/16
 */
public class SeasonDriver {
	/**
	 * Entry point of the application
	 * 
	 * @param args	Not used in this application
	 * 
	 */
	public static void main(String[] args) {
		StormSeason myStormSeason = new StormSeason();
		SeasonTUI mySeasonTUI = new SeasonTUI(myStormSeason);
		mySeasonTUI.run();
	}

}
