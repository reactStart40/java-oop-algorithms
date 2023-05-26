package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import telran.util.*;

import org.junit.jupiter.api.Test;



abstract class ListTest extends CollectionTest{

List<Integer> list = getList();
@Override
protected Collection<Integer> getCollection() {
	return list;
}

	abstract protected <T> List<T> getList() ;
	
	@Test
	void testAddIndex() {
		Integer [] expected0_500 = {500, 10, -20, 7, 50, 100, 30};
		Integer [] expected0_500_3_700 = {500, 10, -20, 700, 7, 50, 100, 30};
		Integer [] expected0_500_3_700_8_300 = {500, 10, -20, 700, 7, 50, 100, 30, 300};
		list.add(0, 500);
		runTest(expected0_500);
		list.add(3, 700);
		runTest(expected0_500_3_700);
		list.add(8, 300);
		runTest(expected0_500_3_700_8_300);
		assertThrowsExactly(IndexOutOfBoundsException.class,
				() ->list.add(list.size() + 1, 100));
		assertThrowsExactly(IndexOutOfBoundsException.class,
				() ->list.add(-1, 100));
		
	}
	@Test
	void testRemoveIndex() {
		Integer [] expectedNo10 = { -20, 7, 50, 100, 30};
		Integer [] expectedNo10_50 = { -20, 7,  100, 30};
		Integer [] expectedNo10_50_30 = { -20, 7,  100};
		assertEquals(10, list.remove(0));
		runTest(expectedNo10);
		assertEquals(50, list.remove(2));
		runTest(expectedNo10_50);
		assertEquals(30, list.remove(3));
		runTest(expectedNo10_50_30);
		assertThrowsExactly(IndexOutOfBoundsException.class,
				() -> list.remove(3));
		assertThrowsExactly(IndexOutOfBoundsException.class,
				() -> list.remove(-3));
		
	}
	@Test
	void testGetIndex() {
		assertEquals(10, list.get(0));
		assertThrowsExactly(IndexOutOfBoundsException.class,
				() -> list.get(list.size()));
		assertThrowsExactly(IndexOutOfBoundsException.class,
				() -> list.get(-1));
	}
	
	@Test
	void testIndexOf() {
		list.add(3, 1280);
		assertEquals(3, list.indexOf(1280));
		assertEquals(-1, list.indexOf((Integer)null));
	}
	@Test
	void testLastIndexOf() {
		list.add(3, 10);
		assertEquals(3, list.lastIndexOf(10));
		assertEquals(-1, list.lastIndexOf((Integer)null));
	}
	
	@Test
	void testSort() {
		Integer expected[] = {-20, 7, 10, 30,  50, 100 };
		list.sort();
		assertArrayEquals(expected,
				list.toArray(new Integer[0]));
	}
	@Test
	void testSortPersons() {
		List<Person> persons = getList();
		Person p1 = new Person(123, 25, "Vasya");
		Person p2 = new Person(124, 20, "Asaf");
		Person p3 = new Person(120, 50, "Arkady");
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		Person expected[] = {p3, p1, p2};
		persons.sort();
		assertArrayEquals(expected, persons.toArray(new Person[0]));
	}
	@Test
	void testSortPersonsByAge() {
		List<Person> persons = getList();
		Person p1 = new Person(123, 25, "Vasya");
		Person p2 = new Person(124, 20, "Asaf");
		Person p3 = new Person(120, 50, "Arkady");
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		Person expected[] = {p3, p1, p2};
		persons.sort((prs1, prs2) -> Integer.compare(prs2.getAge(), prs1.getAge()));
	
		assertArrayEquals(expected,
				persons.toArray(new Person[0]));
		
	}
	@Test
	void testEvenOddSorting() {
		Integer[] expected = { -20,  10, 30, 50, 100, 7, -17};
		list.add(-17);
		//list.sort((a, b) -> evenOddCompare(a, b));
//		list.sort((a, b) -> {
//			int res = Math.abs(a % 2) - Math.abs(b % 2);
//			if (res == 0) {
//				res = a % 2 == 0 ? a - b : b - a;
//			}
//			return res;
//		});
		list.sort(ListTest::evenOddCompare);
		assertArrayEquals(expected, list.toArray(new Integer[0]));
	}
	@Test
	void testIndexOfPredicate()  {
		assertEquals(1, list.indexOf(a -> a < 0));
		list.add(-17);
		assertEquals(-1, list.indexOf(a -> a % 2 != 0 && a > 7));
	}
	@Test
	void clearPerformance() {
		List<Integer> bigList = getList();
		for(int i = 0; i < 1_000_000; i++) {
			bigList.add(i);
		}
		bigList.clear();
	}
	
	
	
	static private int evenOddCompare(Integer a, Integer b) {
		int res = Math.abs(a % 2) - Math.abs(b % 2);
		if (res == 0) {
			res = a % 2 == 0 ? a - b : b - a;
		}
		return res;
	}

}