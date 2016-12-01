package edu.westga.cs6311.storms2.view;
import java.util.Scanner;
import edu.westga.cs6311.storms2.model.Hurricane;
import edu.westga.cs6311.storms2.model.StormSeason;
/**
 * This class creates a user interface to accept input for the 
 * StormSeason class's methods
 * 
 * @author BrandonWilliams
 * @version 11/9/16
 */
public class SeasonTUI {
	private StormSeason myStormSeason;
	private Scanner scan;
	/**
	 * This constructor initializes the instance variables and accepts
	 * a StormSeason object
	 * @param newStormSeason a new StormSeason object
	 */
	public SeasonTUI(StormSeason newStormSeason) {
		this.myStormSeason = newStormSeason;
		this.scan = new Scanner(System.in);
	}
	/**
	 * This method provides options for the user to select and passes 
	 * them on to the appropriate method
	 */
	public void run() {
		System.out.println("Welcome!");
		int userInt = 0;
		while (userInt != 6) {
			this.displayMenu();
			System.out.print("Please enter your choice: ");
			String userInput;
			userInput = this.scan.nextLine();
			userInt = Integer.parseInt(userInput);
			switch (userInt) {
				case 1: 
					this.addHurricane();
					break;
				case 2: 
					this.removeHurricane();
					break;
				case 3:
					this.updateHurricane();
					break;
				case 4: 
					this.displayStatistics();
					break;
				case 5: 
					this.displayBreakdown();
					break;
				case 6: 
					break;
				default: 
					System.out.println("Please enter valid input.");
					break;
			}
		}
		System.out.println("Thank you for using the application.");
	}
	/**
	 * This method displays a menu offering choices to the user
	 */
	public void displayMenu() {
		System.out.println();
		System.out.println("1 - Add a hurricane");
		System.out.println("2 - Remove a hurricane");
		System.out.println("3 - Update a hurricane");
		System.out.println("4 - Display season statistics");
		System.out.println("5 - Display category breakdown");
		System.out.println("6 - Quit");
		System.out.println();
		
	}
	/**
	 * This method allows the user to add a Hurricane object to the ArrayList
	 */
	public void addHurricane() {
		System.out.println();
		System.out.print("Please enter a hurricane name: ");
		String userName = this.scan.nextLine();
		System.out.print("Please enter a hurricane wind speed: ");
		int userSpeed = Integer.parseInt(this.scan.nextLine());
		while (userSpeed < 74) {
			System.out.print("Please enter a value greater than 74: ");
			userSpeed = Integer.parseInt(this.scan.nextLine());
		}
		Hurricane userHurricane = new Hurricane(userName, userSpeed);
		this.myStormSeason.addHurricane(userHurricane);
	}
	/**
	 * This method calls on StormSeason's toString method
	 */
	public void displayStatistics() {
		System.out.println();
		System.out.println(this.myStormSeason.toString());
	}
	/**
	 * This method calls on StormSeason's getCategoryBreakdown and
	 * getCategoryHistogram methods
	 */
	public void displayBreakdown() {
		System.out.println();
		System.out.println(this.myStormSeason.getCategoryBreakdown());
		System.out.println(this.myStormSeason.getCategoryHistogram());
	}
	/**
	 * This method allows the user to remove a Hurricane object from the ArrayList
	 */
	public void removeHurricane() {
		System.out.println();
		System.out.print("Please enter the name of the hurricane you wish to remove: ");
		String userRemove = this.scan.nextLine();
		if (this.myStormSeason.findHurricane(userRemove) == null) {
			System.out.println("There is no hurricane with that name.");
		} else {
			this.myStormSeason.removeHurricane(this.myStormSeason.findHurricane(userRemove));
			System.out.println("Hurricane " + userRemove + " has been removed.");
		}
	}
	/**
	 * This method allows the user to change the wind speed of a Hurricane
	 * object in the ArrayList
	 */
	public void updateHurricane() {
		System.out.println();
		System.out.print("Please enter the name of the hurricane you wish to update: ");
		String userUpdate = this.scan.nextLine();
		if (this.myStormSeason.findHurricane(userUpdate) == null) {
			System.out.println("There is no hurricane with that name.");
		} else {
			System.out.print("Please enter the hurricane's new wind speed: ");
			int newWindSpeed = Integer.parseInt(this.scan.nextLine());
			while (newWindSpeed < 74) {
				System.out.print("Please enter a wind speed greater than 74: ");
				newWindSpeed = Integer.parseInt(this.scan.nextLine());
			}
			this.myStormSeason.updateHurricane(this.myStormSeason.findHurricane(userUpdate), newWindSpeed);
			System.out.println("Hurricane " + userUpdate + " now has a wind speed of " + newWindSpeed);
		} 
			
		
	}
}