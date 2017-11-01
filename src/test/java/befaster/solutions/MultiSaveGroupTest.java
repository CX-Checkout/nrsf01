package befaster.solutions;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

public class MultiSaveGroupTest {

	@Test
	public void discountWithNoMultiSaves() {
		assertEquals(0, MultiSaveGroup.NO_MULTI_SAVES.getDiscount(100));
	}

	
	@Test
	public void discountWithOneMultiSaveNoItems() {
		MultiSaveGroup underTest = new MultiSaveGroup(Collections.singletonList(new MultiSave(3, 10)));
		assertEquals(0, underTest.getDiscount(0));
	}
	
	@Test
	public void discountWithOneMultiSaveNoRemainder() {
		MultiSaveGroup underTest = new MultiSaveGroup(Collections.singletonList(new MultiSave(3, 10)));
		assertEquals(10, underTest.getDiscount(3));
	}
	
	@Test
	public void discountWithOneMultiSaveWithRemainder() {
		MultiSaveGroup underTest = new MultiSaveGroup(Collections.singletonList(new MultiSave(3, 10)));
		assertEquals(10, underTest.getDiscount(4));
	}
	
	@Test
	public void discountWithTwoMultiSavesNoRemainderFromFirstSave() {
		MultiSaveGroup underTest = new MultiSaveGroup(Arrays.asList(new MultiSave(5, 20), 
				new MultiSave(3, 10)));
		assertEquals(20, underTest.getDiscount(5));
	}
	
	@Test
	public void discountWithTwoMultiSavesWithRemainderFromFirstSave() {
		MultiSaveGroup underTest = new MultiSaveGroup(Arrays.asList(new MultiSave(5, 20), 
				new MultiSave(3, 10)));
		assertEquals(50, underTest.getDiscount(14));
	}
}
