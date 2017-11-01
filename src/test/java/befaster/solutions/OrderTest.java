package befaster.solutions;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrderTest {

	Order underTest = new Order(ItemStore.A, 5);
	
	@Test
	public void removeFreewhenNoMatching() {
		assertEquals(underTest, underTest.removeFree(new Order(ItemStore.B, 1)));
	}

	@Test
	public void removeFreeWhenExceedQuantity() {
		assertEquals(new Order(ItemStore.A, 0), underTest.removeFree(new Order(ItemStore.A, 10)));
	}
	
	@Test
	public void removeFreeWhenFreeLessThanQuantity() {
		assertEquals(new Order(ItemStore.A, 3), underTest.removeFree(new Order(ItemStore.A, 2)));
	}
}
