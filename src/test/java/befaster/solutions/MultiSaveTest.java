package befaster.solutions;

import static org.junit.Assert.*;

import org.junit.Test;

public class MultiSaveTest {
	
	private MultiSave underTest = new MultiSave(3, 10);

	@Test
	public void getDiscountWhenSingleItem() {
		assertEquals(0, underTest.getDiscount(1));
	}

	@Test
	public void getDiscountWhenCountMatchesSaveQuantity() {
		assertEquals(10, underTest.getDiscount(3));
	}
	
	@Test
	public void getDiscountWhenCountExceedsSaveQuantity() {
		assertEquals(10, underTest.getDiscount(5));
	}
	
	@Test
	public void getDiscountWhenCountIsMultipleOfSaveQuantity() {
		assertEquals(20, underTest.getDiscount(6));
	}
	
	@Test
	public void getDiscountWhenCountExceedsMultipleOfSaveQuantity() {
		assertEquals(60, underTest.getDiscount(19));
	}
	
	@Test
	public void noMultiSaveGivesNoDiscount() {
		assertEquals(0, MultiSave.NO_MULTI_SAVE.getDiscount(111));
	}
}
