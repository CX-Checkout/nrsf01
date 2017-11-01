package befaster.solutions;

import static org.junit.Assert.*;

import org.junit.Test;

public class MultiSaveTest {
	
	private MultiSave underTest = new MultiSave(3, 10);

	@Test
	public void getDiscountWhenSingleItem() {
		assertEquals(new DiscountResult(0, 1), underTest.getDiscount(1));
	}

	@Test
	public void getDiscountWhenCountMatchesSaveQuantity() {
		assertEquals(new DiscountResult(10, 0), underTest.getDiscount(3));
	}
	
	@Test
	public void getDiscountWhenCountExceedsSaveQuantity() {
		assertEquals(new DiscountResult(10, 2), underTest.getDiscount(5));
	}
	
	@Test
	public void getDiscountWhenCountIsMultipleOfSaveQuantity() {
		assertEquals(new DiscountResult(20, 0), underTest.getDiscount(6));
	}
	
	@Test
	public void getDiscountWhenCountExceedsMultipleOfSaveQuantity() {
		assertEquals(new DiscountResult(60, 1), underTest.getDiscount(19));
	}
	
	@Test
	public void noMultiSaveGivesNoDiscount() {
		assertEquals(new DiscountResult(0, 0), MultiSave.NO_MULTI_SAVE.getDiscount(111));
	}
}
