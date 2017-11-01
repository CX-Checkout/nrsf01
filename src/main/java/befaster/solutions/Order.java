package befaster.solutions;

public class Order {

	private final Item item;
	private final int count;
	
	public Order(Item sku, int count) {
		this.item = sku;
		this.count = count;
	}

	public Item getItem() {
		return item;
	}

	public int getCount() {
		return count;
	}

	@Override
	public int hashCode() {
		int result = item.hashCode();
		result = 31 * result + count;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		
		Order other = (Order) obj;
		if (count != other.count)
			return false;
		if (!item.equals(other.item))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [sku=" + item + ", count=" + count + "]";
	}
}
