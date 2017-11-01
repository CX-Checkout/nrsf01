package befaster.solutions;

public class MultiSave {

	public static MultiSave NO_MULTI_SAVE = new MultiSave(1, 0);
	
	private int groupSize;
	private int discountPerGroup;
	
	public MultiSave(int groupSize, int discountPerGroup) {
		this.groupSize = groupSize;
		this.discountPerGroup = discountPerGroup;
	}
	
	public DiscountResult getDiscount(int number) {
		int groups = number / groupSize;
		int remaining = number % groupSize;
		int discount = groups * discountPerGroup;
		return new DiscountResult(discount, remaining);
	}
}
