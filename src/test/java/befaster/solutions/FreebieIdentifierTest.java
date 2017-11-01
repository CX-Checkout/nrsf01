package befaster.solutions;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import org.junit.Test;

public class FreebieIdentifierTest {
	
	private FreebieIdentifier underTest = new FreebieIdentifier(ItemStore.E, 2, ItemStore.B);

	@Test
	public void noFreebiesWhenNoMatch() {
		assertEquals(Optional.empty(), underTest.identifyAnyFreeOrder(Arrays.asList(new Order(ItemStore.A, 5), new Order(ItemStore.C, 2))));
	}

	@Test
	public void noFreebiesWhenNotEnough() {
		assertEquals(Optional.empty(), underTest.identifyAnyFreeOrder(Collections.singletonList(new Order(ItemStore.E, 1))));
	}

	@Test
	public void freebiesWhenSufficientNumber() {
		assertEquals(Optional.of(new Order(ItemStore.B, 2)), underTest.identifyAnyFreeOrder(Collections.singletonList(new Order(ItemStore.E, 5))));
	}
}
