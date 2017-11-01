package befaster.solutions;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class OrderPricerTest {

	private List<FreebieIdentifier> freebieIdentifiers = Collections.singletonList(new FreebieIdentifier(ItemStore.E, 2, ItemStore.B));
	private OrderPricer underTest = new OrderPricer(freebieIdentifiers);
	
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
	
	@Test
	public void priceMultipleDifferentItemsWithFreebie() {
		assertEquals(250, underTest.price(Arrays.asList(new Order(ItemStore.A, 1), 
				new Order(ItemStore.B, 3),
				new Order(ItemStore.C, 1),
				new Order(ItemStore.D, 1),
				new Order(ItemStore.E, 3))));
	}
}
