package befaster.solutions;

public class Item {
	private char sku;
	private int price;
	private MultiSaveGroup multiSaveGroup;
	
	public Item(char sku, int price) {
		this(sku, price, MultiSaveGroup.NO_MULTI_SAVES);
	}
	
	public Item(char sku, int price, MultiSaveGroup multiSaveGroup) {
		this.sku = sku;
		this.price = price;
		this.multiSaveGroup = multiSaveGroup;
	}

	public char getSku() {
		return sku;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int priceMany(int count) {
		int undiscountedPrice = price * count;
		int discount = multiSaveGroup.getDiscount(count);
		return undiscountedPrice - discount;
	}
	
	@Override
	public String toString() {
		return "Item [sku=" + sku + ", price=" + price + "]";
	}
}
