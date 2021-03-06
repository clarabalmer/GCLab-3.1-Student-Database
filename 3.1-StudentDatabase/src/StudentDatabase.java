import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
public class StudentDatabase {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String[] studentNames = {"Arthur Dent", "Paul Atreides", "Ford Prefect", "Tom Bombadil", "Clara Balmer", "Gandalf the Grey", "Severus Snape", "Steven Universe", "Luke Skywalker", "Aang the Avatar"};
		String[] studentFoods = {"Fish and Chips", "Spice", "Pan Galactic Gargleblasters", "Goldberry's cooking", "Butter", "Sauron's tears", "Pumpkin Pasties", "Cookie Cat ice cream sandwiches", "Blue Milk", "Egg Custard Tarts"};
		String[] studentAnimals = {"Earthlings", "the Muad'dib, a type of desert rodent", "Arthur Dent", "Fatty Lumpkin", "Polar Bears", "Hobbits", "female deers", "Lion", "Yoda", "Appa"};
		
		System.out.println("Welcome to our java class. These are the students:");
		printNames(studentNames);
		System.out.print("Which student would you like to learn more about? (enter a number 1-10): ");
		boolean studentChoiceRepeat = true;
		
		while (studentChoiceRepeat) {
			
			
			try {
				int studentIDChoice = scnr.nextInt();

				boolean infoChoiceRepeat = true;
				
				while (infoChoiceRepeat) {
					printInfoOptions(studentIDChoice, studentNames);
					String infoChoice = scnr.next();
					
					if (infoChoice.equalsIgnoreCase("food")) {
						printFoodFave(studentIDChoice, studentNames, studentFoods);
						if (!yesOrNo(scnr)) {
							infoChoiceRepeat = false;
						}
						
					} else if (infoChoice.equalsIgnoreCase("animal")) {
						printAnimalFave(studentIDChoice, studentNames, studentAnimals);
						if (!yesOrNo(scnr)) {
							infoChoiceRepeat = false;
						}
					} else {
						System.out.println("That data does not exist. (enter \"food\" or \"animal\"): ");
					}
				}
				
				System.out.print("\nWould you like to learn about another student? y/n ");
				if (!yesOrNo(scnr)) {
					studentChoiceRepeat = false;
				} else {
					printNames(studentNames);
					System.out.print("Which student would you like to learn more about? (enter a number 1-10): ");
				}
				
			} catch (InputMismatchException e) {
				scnr.next();
				System.out.print("\nThat isn't a number. Please try again. (enter a number 1-10): ");
			} catch (IndexOutOfBoundsException e) {
				System.out.print("\nThat student does not exist. Please try again. (enter a number 1-10): ");
			}
			
		}
		System.out.println("Thank you!");
		
		
			
		
		
		scnr.close();
	}
	
	public static void printNames(String arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print((i + 1) + ". ");
			System.out.print(arr[i] + "\n");
		}
	}
	public static void printInfoOptions(int n, String names[]) {
		System.out.print("\nStudent " + n + " is " + names[n - 1] + ". What would you like to know about " + firstOnly(n-1, names) + "? (enter \"food\" or \"animal\"): ");
	}
	public static void printFoodFave(int n, String names[], String foods[]) {
		System.out.print(firstOnly(n-1, names) + " loves to eat " + foods[n-1] + ". Would you like to know more? y/n ");
	}
	public static void printAnimalFave(int n, String names[], String animals[]) {
		System.out.print(firstOnly(n-1, names) + " really likes " + animals[n-1] + ". Would you like to know more? y/n ");
	}
	public static boolean yesOrNo(Scanner scnr) {
		try {
			String choice = scnr.next();
			
			if (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")) {
				throw new InputMismatchException("Must be 'y' or 'n'");
			}
			
			if (choice.equalsIgnoreCase("y")) {
				return true;
			} else {
				return false;
			}
		
		} catch (InputMismatchException e) {
			System.out.print("I'm not sure what you want. Please enter y or n: ");
			return (yesOrNo(scnr));
		}
	}
	
	public static String firstOnly(int n, String arr[]) {
		String[] fullNameArr = new String[1];
		fullNameArr[0] = arr[n];
		String name = Arrays.toString(fullNameArr);
		String firstName = "";
		for (int i = 1; i < name.length(); i++) {
			if (name.charAt(i) != ' ') {
				firstName += name.charAt(i);
			} else {
				break;
			}
		}
		return firstName;
	}
	

}
