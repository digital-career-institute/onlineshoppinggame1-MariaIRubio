package exercise_OnlineShoppingGame;

public class Decoration extends VirtualItem{
	
	private String theme;
	
	public Decoration(int itemID, String name, double price, int points, String theme) {
		super(itemID, name, price, points);
		this.theme = theme;
		}

	public String getTheme() {
		return theme;
	}

	@Override
	public String toString() {
		return "Decoration Item\n- ItemID: " + getItemID() + "\n- Name: " + getName() + "\n- Price: €" + getPrice() + "\n- Points: " + getPoints() + "\n- Decoration theme: " + theme + "\n";
	}

	

	

}
