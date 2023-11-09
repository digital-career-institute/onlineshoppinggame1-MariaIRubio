package exercise_OnlineShoppingGame;

public class PowerUp extends VirtualItem {
	
	private String effect;

	public PowerUp(int itemID, String name, double price, int points, String effect) {
		super(itemID, name, price, points);
		this.effect = effect;
	}

	public String getEffect() {
		return effect;
	}

	@Override
	public String toString() {
		return "Power Up Item\n- ItemID: " + getItemID() + "\n- Name: " + getName() + "\n- Price: €" + getPrice() + "\n- Points: " + getPoints() + "\n- PowerUp effect: " + effect + "\n";
				
	}
	
	

}
