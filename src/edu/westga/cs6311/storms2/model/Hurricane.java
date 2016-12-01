package edu.westga.cs6311.storms2.model;

/**
 * Manages information (name and wind speed) about
 * 	a Hurricane
 * 
 * **********************************************
 * ***  DO NOT MODIFY THE CODE IN THIS CLASS  ***
 * ********************************************** 
 * 
 * @author 	CS6311
 * @version	Fall 2016
 *
 */
public class Hurricane {
	private String name;
	private int windSpeed;
	
	/**
	 * Initializes the name and wind speed of a hurricane
	 * 	to the corresponding parameters
	 * 
	 * @param	name		The Hurricane's name
	 * @param	windSpeed	The Hurricane's windSpeed
	 */
	public Hurricane(String name, int windSpeed) {
		if (name == null) {
			name = "";
		}
		if (windSpeed < 74) {
			windSpeed = 74;
		}
		this.name = name;
		this.windSpeed = windSpeed;
	}
	
	/**
	 * Accessor for the hurricane's name
	 * 
	 * @return	The name of this Hurricane
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Accessor for the hurricane's wind speed
	 * 
	 * @return	The wind speed of this Hurricane
	 */
	public int getWindSpeed() {
		return this.windSpeed;
	}
	
	/**
	 * Mutator to set the hurricane's wind speed
	 * @param	windSpeed	The new wind speed
	 * @precondition		windSpeed >= 74
	 */
	public void setWindSpeed(int windSpeed) {
		if (windSpeed < 74) {
			windSpeed = 74;
		}
		this.windSpeed = windSpeed;
	}
	
	/**
	 * Returns a String representation of the Hurricane
	 * 
	 * @return	A String representation of the Hurricane
	 * 			including its name and wind speed
	 */
	public String toString() {
		return "Hurricane " + this.name
				+ " with wind speed " + this.windSpeed;
	}
}
