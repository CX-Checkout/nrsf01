package befaster.solutions;

import static org.junit.Assert.*;

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
		assertEquals(470, Checkout.checkout("ABCDEABCDABCABAA").intValue());
	}
	
	@Test
	public void checkoutLotsOfItemsWithMultipleMultiSavesAndFreebie() {
		assertEquals(495, Checkout.checkout("ABCDEABCDABCABAAE").intValue());
	}
}
