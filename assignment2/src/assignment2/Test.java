package assignment2;

import java.util.Scanner;

public class Test {
	private static Passenger[] passengerArr = new Passenger[12];
	

	public static void main(String[] args) {
		System.out.println("Hello and welcome to SkyBox online booking.");
		menu();
	}

	public static void menu() {
		System.out.println("Choose an action by typing a number:\n\n" + "1: Add Passenger\n" + "2: Remove Passenger\n"
				+ "3: Switch seats\n" + "4: Rename Passenger\n" + "5: Get total Passenger amount\n"
				+ "6: See manifest\n");

		Scanner myScanner = new Scanner(System.in);

		int menuChoice = myScanner.nextInt();

		if (menuChoice == 1) {
			System.out.println("Add Passenger chosen");
			addPassenger();

		} else if (menuChoice == 2) {
			System.out.println("Remove Passenger chosen");
			removePassenger();

		} else if (menuChoice == 3) {
			System.out.println("Switch seats chosen");
			switchSeats();

		} else if (menuChoice == 4) {
			System.out.println("Rename Passenger chosen");
			renamePassenger();

		} else if (menuChoice == 5) {
			System.out.println("Get total Passenger amount chosen");
			getPassengerAmount();

		} else if (menuChoice == 6) {
			System.out.println("See manifest chosen");
			seeManifest();

		} else {
			System.out.println("\nThat number doesn't correlate to any action. Press 1-6 to continue.\n");
			menu();
		}
	}

	public static void addPassenger() {
		Scanner myScanner = new Scanner(System.in);

		for (int i = 0; i < passengerArr.length; i++) {
			if (passengerArr[i] == null) {
			
			Passenger tempPassenger = new Passenger();
			passengerArr[i] = tempPassenger;
			
			System.out.println("Please enter passenger name");
			String name = myScanner.nextLine();
			
			System.out.println("Please enter passenger age");
			int age = myScanner.nextInt();
			
			tempPassenger.setName(name);
			tempPassenger.setAge(age);
			
			String output1 = passengerArr[i].getName() + " has been added to seat number " + (i+1);
			System.out.println(output1 + "\n");
			break;
			} else {
				continue;
			}
		}
		System.out.println("\nRedirecting back to the menu...\n\n\n");
		menu();
	}

	public static void removePassenger() {
		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("Please enter the seatnumber of the passenger you want to remove");
		int seatNumber = myScanner.nextInt();
		passengerArr[seatNumber - 1] = null;
		
		System.out.println("Passenger successfully removed!\nRedirecting back to the menu...\n\n\n");
		menu();
		
	}
	
	public static void switchSeats() {
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Please enter the seatnumber of the passenger you want to have seats switched");
		int oldSeat = myScanner.nextInt();
		
		System.out.println("Please enter the seatnumber you want to switch " + passengerArr[oldSeat - 1].getName() + " to");
		int newSeat = myScanner.nextInt();
		
		Passenger tempPassenger = passengerArr[oldSeat - 1];
		passengerArr[oldSeat - 1] = passengerArr[newSeat - 1];
		passengerArr[newSeat - 1] = tempPassenger;
		
		System.out.println(passengerArr[newSeat - 1].getName() + " has switched seat to seat number " + (newSeat));
		
		System.out.println("\nRedirecting back to the menu...\n\n\n");
		menu();
	}
	
	public static void renamePassenger() {
		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("Please enter the seatnumber of the passenger you want to rename");
		int seatNumber = myScanner.nextInt();
			myScanner.nextLine();
		
		if (passengerArr[seatNumber - 1] == null) {
			System.out.println("No passenger on given seat number. Try again.");
			renamePassenger();
		}else {
			System.out.println("Please enter the new name of the passenger");
		String newName = myScanner.nextLine();
		
		
		passengerArr[seatNumber - 1].setName(newName);
		System.out.println("Passenger has been renamed to " + passengerArr[seatNumber - 1].getName());
		
		System.out.println("\nRedirecting back to the menu...\n\n\n\n");
		menu();
		
		}
		
		
	}
	
	public static void getPassengerAmount() {
		int passengerAmount = 0;
		for (int i = 0; i < passengerArr.length; i++) {
			if (passengerArr[i] != null) {
				passengerAmount++;
			}
		}
		
		System.out.println("The number of passengers are: " + passengerAmount);
		
		System.out.println("\nRedirecting back to the menu...\n\n\n");
		menu();
	}
	
	public static void seeManifest(){	
		System.out.println(
		"\n#### PASSENGER MANIFEST #####" + 
		"\nSkybox Ltd.\n" + 
		"Seat\t\tName\t\tAge");
		
		for (int i = 0; i < passengerArr.length; i++) {
			
			if (passengerArr[i] == null) {
				System.out.println(i + 1);
			}
			if (passengerArr[i] != null) {
				System.out.println((i + 1) + "\t\t" + passengerArr[i].getName() + "\t\t" + passengerArr[i].getAge());
				}
		}
		
		System.out.println("##### ##### ##### ##### ##### ###");
		
		System.out.println("\nRedirecting back to the menu...\n\n\n");
		menu();
	}
}
