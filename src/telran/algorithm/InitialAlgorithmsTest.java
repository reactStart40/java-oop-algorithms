package telran.algorithm;

import static org.junit.jupiter.api.Assertions.*;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static telran.algorithm.initialAlgorithms.*;

class InitialAlgorithmsTest {
 int N_NUMBERS = 100000;
 short[] array;

 void setUpBigArray() {
	 
	 array = new short[N_NUMBERS];
	 for(int i = 0; i < N_NUMBERS; i++) {
		 array[i] = (short) (Math.random() * Short.MAX_VALUE);
	 }
 }
	@Test
	@Disabled
	void bubbleSortTest() {
		setUpBigArray();
		bubbleSort(array);
		runTest();
	}
	@Test
	void SortPositiveShortTest() {
		setUpBigArray();
		sortShortPositive(array);
		runTest();
	}
	private void runTest() {
		for(int i = 1; i < N_NUMBERS; i++) {
			assertTrue(array[i - 1] <= array[i]);
		}
		
	}
	@Test
	void isSum2Test() {
		short[] array = {30000, 1, 5, 2, 10000, 0, 500,0};
		short[] array1 = {30000, 1, 5, 2, 10000, 0, 500,0, Short.MAX_VALUE};
		assertTrue(isSum2(array, (short)30000));
		assertTrue(isSum2(array, (short)7));
		assertFalse(isSum2(array, (short)30003));
		assertFalse(isSum2(array, (short)8));
		assertTrue(isSum2(array1, Short.MIN_VALUE));
		
	}
	@Test
	void getMaxPositiveWithNegativeTest() {
		short[] array = {1, 1, 1, -1, 20, 100,200, 100 -100, -100, -20, -40, 80};
		short[] array1 = {-40, 1, -40, -6, 2, 3, 40};
		short[] array2 = {40, 1, 2, 3, 40, -30};
		assertEquals(100,
				getMaxPositiveWithNegativeReflect(array));
		assertEquals(40,
				getMaxPositiveWithNegativeReflect(array1));
		assertEquals(-1,
				getMaxPositiveWithNegativeReflect(array2));
	}
	@Test
	@Disabled
	void maxValueComplexityNTest() {
		assertEquals(Long.MAX_VALUE, getMaxValueComplexityN());
	}
	@Test
	void maxValueComplexityLogNTest() {
		assertEquals(Long.MAX_VALUE, getMaxValueComplexityLogN());
	}
	private Long getMaxValueComplexityN() {
		long res = 1;
		while(res > 0) {
			res++;
		}
		return res - 1;
	}
	private Long getMaxValueComplexityLogN() {
		long res = 1;
		while(res > 0) {
			res *= 2;
		}
		return res - 1;
	}
	
	@Test
	public void testBinarySearchInsert() {
	    Integer[] arr = {1, 3, 5, 7, 9};
	    int index1 = binarySearchInsert(arr, 5, Integer::compare, 5);
	    assertEquals(2, index1);

	    int index2 = binarySearchInsert(arr, 4, Integer::compare, 4);
	    assertEquals(2, index2);

	    int index3 = binarySearchInsert(arr, 0, Integer::compare, 0);
	    assertEquals(0, index3);

	    int index4 = binarySearchInsert(arr, 10, Integer::compare, 10);
	    assertEquals(5, index4);

	    int index5 = binarySearchInsert(arr, 8, Integer::compare, 6);
	    assertEquals(3, index5);

	    Integer[] arr2 = {};
	    int index6 = binarySearchInsert(arr2, 5, Integer::compare, 5);
	    assertEquals(0, index6);

	  
	    Integer[] arr3 = {5};
	    int index7 = binarySearchInsert(arr3, 5, Integer::compare, 5);
	    assertEquals(0, index7);
	    int index8 = binarySearchInsert(arr3, 6, Integer::compare, 6);
	    assertEquals(1, index8);
	}

}
