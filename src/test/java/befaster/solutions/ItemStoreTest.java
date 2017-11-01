package befaster.solutions;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ItemStoreTest {

	private ItemStore underTest=  new ItemStore();
	
	@Test
	public void getItems() {
		assertEquals(Arrays.asList(ItemStore.A, ItemStore.B, ItemStore.C, ItemStore.D, ItemStore.E), underTest.getItems());
	}

	@Test
	public void getItemSkus() {
		assertEquals(Arrays.asList('A', 'B', 'C', 'D', 'E'), underTest.getItemSkus());
	}
	
	@Test
	public void lookupItemReturnsMatchingItem() {
		assertEquals(ItemStore.A, underTest.lookupItem('A'));
	}
	
	@Test
	public void lookupItemReturnsNullIfNoMatch() {
		assertNull(underTest.lookupItem('Z'));
	}
}
