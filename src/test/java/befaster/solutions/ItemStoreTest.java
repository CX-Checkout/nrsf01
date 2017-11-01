package befaster.solutions;

import static befaster.solutions.ItemStore.*;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ItemStoreTest {

	private ItemStore underTest=  new ItemStore();
	
	@Test
	public void getItems() {
		assertEquals(Arrays.asList(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z), underTest.getItems());
	}

	@Test
	public void getItemSkus() {
		assertEquals(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'), underTest.getItemSkus());
	}
	
	@Test
	public void lookupItemReturnsMatchingItem() {
		assertEquals(A, underTest.lookupItem('A'));
	}
	
	@Test
	public void lookupItemReturnsNullIfNoMatch() {
		assertNull(underTest.lookupItem('_'));
	}
}
