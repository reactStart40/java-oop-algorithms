package telran.util.test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import telran.util.*;

class ArrayListTest {
	List<Integer> list;
	Integer[] numbers = { 10, -20, 7, 50, 100, 30 };

	@BeforeEach
	void setUp() {
		list = new ArrayList<>(1);
		for (int i = 0; i < numbers.length; i++) {
			list.add(numbers[i]);

		}
	}

	@Test
	void testAdd() {
		assertTrue(list.add(numbers[0]));
		assertEquals(numbers.length + 1, list.size());

	}

	@Test
	public void testAddIndex() {
		Integer[] expected0_500 = { 500, 10, -20, 7, 50, 100, 30 };
		Integer[] expected0_500_3_700 = { 500, 10, -20, 700, 7, 50, 100, 30 };
		Integer[] expected0_500_3_700_8_300 = { 500, 10, -20, 700, 7, 50, 100, 30, 300 };

		list.add(0, 500);
		runTest(expected0_500);
		list.add(3, 700);
		runTest(expected0_500_3_700);
		list.add(8, 300);
		runTest(expected0_500_3_700_8_300);
	}

	@Test
	void testRemoveIndex() {

		Integer[] expectedNo10 = { -20, 7, 50, 100, 30 };
		Integer[] expectedNo10_50 = { -20, 7, 100, 30 };
		Integer[] expectedNo10_50_30 = { -20, 7, 100 };
		assertEquals(10, list.remove(0));
		runTest(expectedNo10);
		assertEquals(50, list.remove(2));
		runTest(expectedNo10_50);
		assertEquals(30, list.remove(3));
		runTest(expectedNo10_50_30);
	}

	@Test
	void testGetIndex() {
		assertEquals(10, list.get(0));

	}

	@Test
	void testIndexOf() {
		list.add(3, 10);
		assertEquals(0, list.indexOf(10));
		assertEquals(-1, list.indexOf(null));

	}

	private void runTest(Integer[] expected) {
		Integer[] actual = list.toArray(new Integer[0]);
		assertArrayEquals(expected, actual);
	}

	@Test
	void testlastIndexOf() {
		list.add(6, 10);
		assertEquals(6, list.lastIndexOf(10));
		assertEquals(-1, list.lastIndexOf(200));

	}

	@Test
	void testRemove() {

		Integer[] expected1 = { -20, 7, 50, 100, 30 };
		Integer[] expected2 = { -20, 7, 100, 30 };
		Integer[] expected3 = { -20, 7, 100 };

		assertTrue(list.remove(Integer.valueOf(10)));
		runTest(expected1);

		assertTrue(list.remove(Integer.valueOf(50)));
		runTest(expected2);
		assertFalse(list.remove(Integer.valueOf(99)));

		assertTrue(list.remove(Integer.valueOf(30)));
		runTest(expected3);
	}

	@Test
	void testToArray() {
		Integer[] actual = list.toArray(new Integer[0]);
		assertArrayEquals(numbers, actual);

		Integer[] buffer = new Integer[3];
		actual = list.toArray(buffer);
		assertArrayEquals(numbers, actual);

		buffer = new Integer[5];
		actual = list.toArray(buffer);
		assertArrayEquals(numbers, actual);

		buffer = new Integer[6];
		actual = list.toArray(buffer);
		assertArrayEquals(numbers, actual);
	}

}
