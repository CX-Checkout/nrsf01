package befaster.solutions;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class GroupDiscountTest {

	private GroupDiscount underTest = new GroupDiscount();
	
	@Test
	public void ignoreOtherItems() {
		List<Order> orders = Arrays.asList(new Order(ItemStore.A, 10), new Order(ItemStore.U, 15));
		assertEquals(0, underTest.calculateGroupDiscount(orders));
	}

	@Test
	public void doNotReducePriceWhenNotEnough() {
		List<Order> orders = Arrays.asList(new Order(ItemStore.S, 2));
		assertEquals(0, underTest.calculateGroupDiscount(orders));
	}
	
	@Test
	public void reducePriceForGroup() {
		assertEquals(15, underTest.calculateGroupDiscount(Arrays.asList(new Order(ItemStore.S, 3))));
		assertEquals(15, underTest.calculateGroupDiscount(Arrays.asList(new Order(ItemStore.T, 3))));
		assertEquals(6, underTest.calculateGroupDiscount(Arrays.asList(new Order(ItemStore.X, 3))));
		assertEquals(15, underTest.calculateGroupDiscount(Arrays.asList(new Order(ItemStore.Y, 3))));
		assertEquals(18, underTest.calculateGroupDiscount(Arrays.asList(new Order(ItemStore.Z, 3))));
	}
	
	@Test
	public void reducePriceForEachGroupOfMany() {
		List<Order> orders = Arrays.asList(new Order(ItemStore.S, 3),
				new Order(ItemStore.T, 3),
				new Order(ItemStore.X, 3),
				new Order(ItemStore.Y, 3),
				new Order(ItemStore.Z, 3));
		assertEquals(69, underTest.calculateGroupDiscount(orders));
	}
	
	@Test
	public void removePricierItemsFirst() {
		List<Order> orders = Arrays.asList(new Order(ItemStore.S, 1),
				new Order(ItemStore.T, 1),
				new Order(ItemStore.X, 1),
				new Order(ItemStore.Y, 1),
				new Order(ItemStore.Z, 1));
		assertEquals(16, underTest.calculateGroupDiscount(orders));
	}
	
	@Test
	public void removePricierItemsFirstWithMore() {
		List<Order> orders = Arrays.asList(new Order(ItemStore.S, 1),
				new Order(ItemStore.T, 0),
				new Order(ItemStore.X, 3),
				new Order(ItemStore.Y, 3),
				new Order(ItemStore.Z, 4));
		assertEquals(46, underTest.calculateGroupDiscount(orders));
	}
}
