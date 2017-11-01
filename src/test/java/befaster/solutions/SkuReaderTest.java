package befaster.solutions;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class SkuReaderTest {

	private SkuReader underTest = new SkuReader(new ItemStore());
	
	@Test(expected = IllegalArgumentException.class)
	public void throwsExceptionOnInvalidInput() {
		underTest.parseSkus("Z");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void throwsExceptionOnLaterInvalidInput() {
		underTest.parseSkus("ABCDZ");
	}
	
	@Test
	public void nullInputReturnsEmptyList() {
		assertEquals(Collections.emptyList(), underTest.parseSkus(null));
	}
	
	@Test
	public void emptyInputReturnsEmptyList() {
		assertEquals(Collections.emptyList(), underTest.parseSkus(""));
	}
	
	@Test
	public void checkoutA() {
		List<Order> expected = Arrays.asList(new Order(ItemStore.A, 1));
		assertEquals(expected, underTest.parseSkus("A"));
	}
	
	@Test
	public void checkoutTwoA() {
		List<Order> expected = Arrays.asList(new Order(ItemStore.A, 2));
		assertEquals(expected, underTest.parseSkus("AA"));
	}

	@Test
	public void checkoutB() {
		List<Order> expected = Arrays.asList(new Order(ItemStore.B, 1));
		assertEquals(expected, underTest.parseSkus("B"));
	}
	
	@Test
	public void checkoutTwoATwoB() {
		List<Order> expected = Arrays.asList(new Order(ItemStore.A, 2), new Order(ItemStore.B, 2));
		assertEquals(expected, underTest.parseSkus("AABB"));
	}
	
	@Test
	public void checkoutC() {
		List<Order> expected = Arrays.asList(new Order(ItemStore.C, 1));
		assertEquals(expected, underTest.parseSkus("C"));
	}
	
	@Test
	public void checkoutD() {
		List<Order> expected = Arrays.asList(new Order(ItemStore.D, 1));
		assertEquals(expected, underTest.parseSkus("D"));
	}
	
	@Test
	public void checkoutMix() {
		List<Order> expected = Arrays.asList(new Order(ItemStore.D, 4), 
				new Order(ItemStore.C, 3), 
				new Order(ItemStore.B, 2), 
				new Order(ItemStore.A, 1));
		assertEquals(expected, underTest.parseSkus("DCBADCBDCD"));
	}
}
