package view;

import java.util.List;
import java.util.Scanner;

import controller.ListItemHelper;
import model.ListItem;

public class StartProgram {
	static Scanner in = new Scanner(System.in);
	static ListItemHelper lih = new ListItemHelper();

	
//add is done.
	private static void addAPet() {
		// TODO Auto-generated method stub
		System.out.print("Enter a Name: ");
		String name = in.nextLine();
		System.out.print("Enter an Breed: ");
		String breed = in.nextLine();
		System.out.print("Enter the Weight: ");
		String weight = in.nextLine();

		ListItem toInsert = new ListItem(name, breed, weight);

		lih.insertItem(toInsert);

	}
//delete is done.
	private static void deleteAPet() {
		// TODO Auto-generated method stub
		System.out.print("Enter the name to delete: ");
		String name = in.nextLine();
		System.out.print("Enter the breed to delete: ");
		String breed = in.nextLine();
		System.out.print("Enter the weight to delete: ");
		String weight = in.nextLine();
		ListItem toDelete = new ListItem(name, breed, weight);
		
		lih.deleteItem(toDelete);
	}

//edit is not done.
	private static void editAPet() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Name");
		System.out.println("2 : Search by Breed");
		System.out.println("3 : Search by Weight");
		int searchBy = in.nextInt();
		in.nextLine();
		List<ListItem> foundPets;
		if (searchBy == 1) {
			System.out.print("Enter the pet's name: ");
			String petName = in.nextLine();
			foundPets = lih.searchForPetByName(petName);
		} else {
			System.out.print("Enter the pet's breed: ");
			String petBreed = in.nextLine();
			foundPets = lih.searchForPetByBreed(petBreed);

		}
		 
		if (!foundPets.isEmpty()) {
			System.out.println("Found Results."); //name
			for (ListItem l : foundPets) {
				System.out.println(l.getName() + " : " + l.toString());
			}

		} else {
			System.out.println("---- No results found");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

//run menu is done.
	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to our Pet list! ---");
		while (goAgain) {
			System.out.println("*  Select:");
			System.out.println("*  1 -- Add a pet");
			System.out.println("*  2 -- Edit a pet");
			System.out.println("*  3 -- Delete a pet");
			System.out.println("*  4 -- View the list of pets");
			System.out.println("*  5 -- Exit the program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAPet();
			} else if (selection == 2) {
				editAPet();
			} else if (selection == 3) {
				deleteAPet();
			} else if (selection == 4) {
				viewThePets();
			} else {
				lih.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}

//view the list is not done.
	private static void viewThePets() {
		// TODO Auto-generated method stub
		List<ListItem> allPets = lih.showAllPets();
		for(ListItem l : allPets){
			System.out.println(l.toString());
		}

	}

}
