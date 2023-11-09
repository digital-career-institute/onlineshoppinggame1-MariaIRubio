package exercise_OnlineShoppingGame;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Methods {
	
	List<VirtualItem> listVirtualItems = new ArrayList<>();
	List<VirtualItem> shoppingCart = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);

	{
		listVirtualItems.add(new VirtualItem(1001, "Coin Pack", 3.99, 5));
		listVirtualItems.add(new VirtualItem(1002, "Extra Life Token", 24.99, 30));
		listVirtualItems.add(new VirtualItem(1003, "Speed Boost Position", 11.99, 15));
		listVirtualItems.add(new PowerUp(2001, "Mushroom PowerUp", 15.99, 20, "Double Size"));
		listVirtualItems.add(new PowerUp(2002, "Fire Flower PowerUp", 24.99, 30, "Fire Ball Attack"));
		listVirtualItems.add(new PowerUp(2003, "Star PowerUp", 39.99, 50, "Invincibility"));
		listVirtualItems.add(new Decoration(3001, "Mushroom Kingdom Castle Decoration", 12.99, 15, "Castle"));
		listVirtualItems.add(new Decoration(3002, "Pipe Decoration", 8.99, 10, "Underground"));
		listVirtualItems.add(new Decoration(3003, "Magic Bridge Decoration", 10.99, 12, "Fantasy"));
	}

	public void displayItems() {

		listVirtualItems.forEach(System.out::println);
	}

	public void addItem() {

		System.out.print("\nHow many items do you want to add to the Cart?: ");
		int items = scanner.nextInt();

		for (int i = 0; i < items; i++) {
			System.out.print("\nEnter the Id of the Item " + (i + 1) + " ");
			int selectedIdItems = scanner.nextInt();

			boolean found = false;
			for (VirtualItem item : listVirtualItems) {
				if (item.getItemID() == selectedIdItems) {
					shoppingCart.add(item);
					System.out.println("Item added to the Cart: " + item.getName());
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("\nItem with ID " + selectedIdItems + " not found. Please enter a valid ID.");
				i--;
			}
		}
	}

	public void removeItem() {
		
		if(!shoppingCart.isEmpty()) {
		System.out.print("How many items do you want to remove from the Cart?: ");
		int items = scanner.nextInt();
		if(items <= shoppingCart.size()) {
		for (int i = 0; i < items; i++) {
			System.out.print("\nEnter the Id of the Item " + (i + 1) + " ");
			int selectedIdItems = scanner.nextInt();

			boolean found = false;
			for (VirtualItem item : shoppingCart) {
				if (item.getItemID() == selectedIdItems) {
					shoppingCart.remove(item);
					System.out.println("Item removed from the Cart: " + item.getName());
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("\nItem with ID " + selectedIdItems + " not found. Please enter a valid ID.");
				i--;
			}
		}
		}else {
			System.out.println("\nThere is not such amount in your Cart. Take a better look.");
			System.out.println("You have only " + shoppingCart.size() + " items in your Cart.");
		}
		}else {
			System.out.println("Shopping Cart is empty.");
		}
	}

	public void displayCart() {
		if(!shoppingCart.isEmpty()) {
		shoppingCart.forEach(System.out::println);
		}else {System.out.println("Shopping Cart is empty");}
	}

	public void displayPoints() {
		int initialPoints = 100;
		int totalPoints = 0;

		for (VirtualItem item : shoppingCart) {
			totalPoints += item.getPoints();
			System.out.println("-" + item.getName() + " " + item.getPoints() + " points");
		}
		System.out.println("\nYour initial points: " + initialPoints);
		System.out.println("Points for this purchase: " + totalPoints);
		System.out.println("Total point: " + (initialPoints + totalPoints));
		System.out.println("\nYou can add more points buying items with higher points!");

		System.out.println("Here there is a selection of the items with higher points.\n");
		for (VirtualItem item : listVirtualItems) {
			if (item.getPoints() >= 20) {
				System.out.println(item);
			}
		}
	}

	public void purchase() {
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		shoppingCart.forEach(System.out::println);
		if (!shoppingCart.isEmpty()) {
			double totalPrice = 0;
			for (VirtualItem item : shoppingCart) {
				totalPrice += item.getPrice();
				System.out.println("-" + item.getName() + " €" + item.getPrice());
			}
			String formattedPrice = decimalFormat.format(totalPrice);
			System.out.println("Total Price: €" + formattedPrice);
		}else {System.out.println("\nShopping Cart is empty.");}
	}
}
