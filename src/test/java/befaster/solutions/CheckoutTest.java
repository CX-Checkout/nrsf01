package befaster.solutions;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class CheckoutTest {

	@Test
	public void returnsNegativeOnInvalidInput() {
		assertEquals(-1, Checkout.checkout("_").intValue());
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
	
	@Test
	public void priceGtoZ() {
		assertEquals(20, Checkout.checkout("G").intValue());
		assertEquals(10, Checkout.checkout("H").intValue());
		assertEquals(45, Checkout.checkout("HHHHH").intValue());
		assertEquals(80, Checkout.checkout("HHHHHHHHHH").intValue());
		assertEquals(135, Checkout.checkout("HHHHHHHHHHHHHHHH").intValue());
		assertEquals(35, Checkout.checkout("I").intValue());
		assertEquals(60, Checkout.checkout("J").intValue());
		assertEquals(70, Checkout.checkout("K").intValue());
		assertEquals(120, Checkout.checkout("KK").intValue());
		assertEquals(190, Checkout.checkout("KKK").intValue());
		assertEquals(90, Checkout.checkout("L").intValue());
		assertEquals(15, Checkout.checkout("M").intValue());
		assertEquals(40, Checkout.checkout("N").intValue());
		assertEquals(10, Checkout.checkout("O").intValue());
		assertEquals(50, Checkout.checkout("P").intValue());
		assertEquals(200, Checkout.checkout("PPPPP").intValue());
		assertEquals(250, Checkout.checkout("PPPPPP").intValue());
		assertEquals(30, Checkout.checkout("Q").intValue());
		assertEquals(80, Checkout.checkout("QQQ").intValue());
		assertEquals(110, Checkout.checkout("QQQQ").intValue());
		assertEquals(50, Checkout.checkout("R").intValue());
		assertEquals(20, Checkout.checkout("S").intValue());
		assertEquals(20, Checkout.checkout("T").intValue());
		assertEquals(40, Checkout.checkout("U").intValue());
		assertEquals(120, Checkout.checkout("UUUU").intValue());
		assertEquals(160, Checkout.checkout("UUUUU").intValue());
		assertEquals(50, Checkout.checkout("V").intValue());
		assertEquals(90, Checkout.checkout("VV").intValue());
		assertEquals(130, Checkout.checkout("VVV").intValue());
		assertEquals(180, Checkout.checkout("VVVV").intValue());
		assertEquals(20, Checkout.checkout("W").intValue());
		assertEquals(17, Checkout.checkout("X").intValue());
		assertEquals(20, Checkout.checkout("Y").intValue());
		assertEquals(21, Checkout.checkout("Z").intValue());
	}
	
	@Test
	public void testFreebies() {
		assertEquals(80, Checkout.checkout("EEB").intValue());
		assertEquals(120, Checkout.checkout("NNNM").intValue());
		assertEquals(150, Checkout.checkout("RRRQ").intValue());
	}
}
