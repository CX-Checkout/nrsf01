package befaster.solutions;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class CheckoutTest {

	@Test
	public void returnsNegativeOnInvalidInput() {
		assertEquals(-1, Checkout.checkout("Z").intValue());
	}
	
	@Test
	public void checkoutA() {
		assertEquals(50, Checkout.checkout("A").intValue());
	}

	@Test
	public void checkoutB() {
		assertEquals(30, Checkout.checkout("B").intValue());
	}
	
	@Test
	public void checkoutC() {
		assertEquals(20, Checkout.checkout("C").intValue());
	}
	
	@Test
	public void checkoutD() {
		assertEquals(15, Checkout.checkout("D").intValue());
	}
	
	@Test
	public void checkoutLotsOfOneItem() {
		assertEquals(90, Checkout.checkout("DDDDDD").intValue());
	}
	
	@Test
	public void checkoutLotsOfItems() {
		assertEquals(150, Checkout.checkout("ABCCDD").intValue());
	}
	
	@Test
	public void checkoutLotsOfItemsWithMultiSave() {
		assertEquals(310, Checkout.checkout("ABCDABCABA").intValue());
	}
	
	@Test
	public void checkoutLotsOfItemsWithMultipleMultiSaves() {
		assertEquals(480, Checkout.checkout("ABCDEABCDABCABAAF").intValue());
	}
	
	@Test
	public void checkoutLotsOfItemsWithMultipleMultiSavesAndFreebie() {
		assertEquals(515, Checkout.checkout("ABCDEABCDABCABAAEFF").intValue());
	}
	
	@Test
	public void priceFs() {
		assertEquals(20, Checkout.checkout("FF").intValue());
		assertEquals(20, Checkout.checkout("FFF").intValue());
		assertEquals(30, Checkout.checkout("FFFF").intValue());
		assertEquals(40, Checkout.checkout("FFFFFF").intValue());
	}
}
