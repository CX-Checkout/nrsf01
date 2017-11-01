package befaster.solutions;

public class DiscountResult {
	private int discount;
	private int remaining;
	
	public DiscountResult(int discount, int remaining) {
		this.discount = discount;
		this.remaining = remaining;
	}

	public int getDiscount() {
		return discount;
	}

	public int getRemaining() {
		return remaining;
	}

	@Override
	public int hashCode() {
		int result = discount;
		result = 31 * result + remaining;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		DiscountResult other = (DiscountResult) obj;
		if (discount != other.discount)
			return false;
		if (remaining != other.remaining)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DiscountResult [discount=" + discount + ", remaining=" + remaining + "]";
	}
	
	
}
