package befaster.solutions;

import static org.junit.Assert.*;

import org.junit.Test;

public class ItemTest {

	private Item itemWithSave = new Item('E', 13, new MultiSave(4, 52 - 50));
	private Item itemWithoutSave = new Item('F', 13);
	
	@Test
	public void priceManyForItemWithoutMultiSave() {
		assertEquals(273, itemWithoutSave.priceMany(21));
	}

	@Test
	public void priceWithoutDiscountForItemWithMultiSave() {
		assertEquals(39, itemWithSave.priceMany(3));
	}
	
	@Test
	public void priceWithDiscountForItemWithMultiSaveForSingleGroup() {
		assertEquals(50, itemWithSave.priceMany(4));
	}
	
	@Test
	public void priceWithDiscountForItemWithMultiSaveForLotsOfGroups() {
		assertEquals(263, itemWithSave.priceMany(21));
	}
	
	@Test
	public void aDiscounts() {
		assertEquals(130, ItemStore.A.priceMany(3));
	}
	
	@Test
	public void bDiscounts() {
		assertEquals(45, ItemStore.B.priceMany(2));
	}
}
