package befaster.solutions;

public class Item {
	private char sku;
	private int price;
	private MultiSave multiSave;
	
	public Item(char sku, int price) {
		this(sku, price, MultiSave.NO_MULTI_SAVE);
	}
	
	public Item(char sku, int price, MultiSave multiSave) {
		this.sku = sku;
		this.price = price;
		this.multiSave = multiSave;
	}

	public char getSku() {
		return sku;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int priceMany(int count) {
		int undiscountedPrice = price * count;
		int discount = multiSave.getDiscount(count);
		return undiscountedPrice - discount;
	}
	
	@Override
	public String toString() {
		return "Item [sku=" + sku + ", price=" + price + "]";
	}
}
