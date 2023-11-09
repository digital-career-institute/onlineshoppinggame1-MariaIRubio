package exercise_OnlineShoppingGame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	Methods method = new Methods();

	public void displayMenu() {
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		
		do {
			try {
			System.out.println("\nMenu:\n");
			System.out.println("1. Display Items");
			System.out.println("2. Add Item(s) to the cart");
			System.out.println("3. Remove Item from the cart");
			System.out.println("4. Display Cart");
			System.out.println("5. Display Points");
			System.out.println("6. Purchase");
			System.out.println("7. Exit the shop");

			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				System.out.println("\n1. Display Items\n");
				method.displayItems();
				break;

			case 2:
				System.out.println("\n2. Add Item(s) to the cart");
				method.addItem();
				break;

			case 3:
				System.out.println("\n3. Remove Item from the cart\n");
				method.removeItem();
				break;

			case 4:
				System.out.println("\n4. Display Cart\n");
				method.displayCart();
				break;

			case 5:
				System.out.println("\n5. Display Points");
				method.displayPoints();
				break;

			case 6:
				System.out.println("\n5. Purchase");
				method.purchase();
				break;

			case 7:
				System.out.println("\n7. Exit the program");
				System.out.println("Exiting the program.");
				break;

			default:
				System.out.println("Invalid option. Please choose a right option.");
				scanner.next();
				choice = 0;
			}
			}catch(InputMismatchException e) {
				System.out.println("Invalid input. Please enter a valid number.");
				scanner.next();
			}

		} while (choice != 7);
		
		scanner.close();

}
}
