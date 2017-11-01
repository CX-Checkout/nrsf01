package befaster.solutions;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

public class SkuLineParserTest {

	private SkuLineParser underTest = new SkuLineParser();
	
	@Test
	public void nullReturnsEmptyList() {
		assertArrayEquals(new char[0], underTest.parse(null));
	}

	@Test
	public void emptyReturnsEmptyList() {
		assertArrayEquals(new char[0], underTest.parse(""));
	}
	
	@Test
	public void splitsLineIntoList() {
		assertArrayEquals(new char[]{'a', 'b', 'c', 'd'}, underTest.parse("abcd"));
	}
	
}
