package befaster.solutions;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

public class OrderPricerTest {

	private OrderPricer underTest = new OrderPricer();
	
	@Test
	public void priceEmptyList() {
		assertEquals(0, underTest.price(Collections.emptyList()));
	}

	@Test
	public void priceSingleItem() {
		assertEquals(50, underTest.price(Collections.singletonList(new Order(ItemStore.A, 1))));
	}
	
	@Test
	public void priceMultipleOfSameItem() {
		assertEquals(100, underTest.price(Collections.singletonList(new Order(ItemStore.A, 2))));
	}
	
	@Test
	public void priceMultipleDifferentItems() {
		assertEquals(115, underTest.price(Arrays.asList(new Order(ItemStore.A, 1), 
				new Order(ItemStore.B, 1),
				new Order(ItemStore.C, 1),
				new Order(ItemStore.D, 1))));
	}
}
