package telran.algorithm.test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static telran.algorithm.initialAlgorithms.*;

class AlgorithmTest {
	public static short[] createRandomShortArray() {
	    short[] arr = new short[100000];
	    for (int i = 0; i < arr.length; i++) {
	        arr[i] = (short) (Math.random() * Short.MAX_VALUE);
	    }
	    return arr;
	}



	@Test
	void testSortShortPositive() {
		short[] array1 = {1, 8, 3, 12, 0};
		short[] array2 = {1, 2, 4, 2, 4, 1};	
		short[] array3 = {};
		short[] array4 = {0, 0, 0};
		
		short []expected1 = {0, 1, 3, 8, 12};
		short []expected2 = {1,1,2,2,4,4};
		short []expected3 = {};
		short []expected4  = {0,0,0};
		sortShortPositive(array1);
		sortShortPositive(array2);
		sortShortPositive(array3);
		sortShortPositive(array4);
	 assertArrayEquals(expected1, array1);
	 assertArrayEquals(expected2, array2);
	 assertArrayEquals(expected3, array3);
	 assertArrayEquals(expected4, array4);
	}

	@Test
	public void testIsSum2() {
		short[] array1 = {1, 2, 3, 4, 5};
		short[] array2 = {10, 20, 30, 40, 50};
		short[] array3 = {-2, 0, 2, 4, 6, 8};
		short[] array4 = {-32768, -32767, -32766, 0, 32765, 32766, 32767};
		short[] array5 = {Short.MAX_VALUE, Short.MIN_VALUE, 0, 1, -1};
		
		assertTrue(isSum2(array1, (short)5));
		assertTrue(isSum2(array2, (short)70));
		assertTrue(isSum2(array3, (short)4));
		assertTrue(isSum2(array4, (short)0));
		assertFalse(isSum2(array5, (short)5));
	}
	@Test
	public void testBubbleSort() {
	   short[] arr1 = { 5, 3, 8, 1, 2 };
	   short[] arr2 = { 5, -3, 8, -1, 2 };
	   short[] arr3 = { 5, 3, 8, 1, 2, 5, 1 };
	   
	   bubbleSort(arr1);
	   bubbleSort(arr2);
	   bubbleSort(arr3);
	   
	   assertArrayEquals(new short[]{1, 2, 3, 5, 8}, arr1);
	   assertArrayEquals(new short[]{-3, -1, 2, 5, 8}, arr2);
	   assertArrayEquals(new short[]{1, 1, 2, 3, 5, 5, 8}, arr3);
	}

	@Test

	public void testGetMaxPositiveWithNegativeReflect1() {
	   
	    short[] array1 = { 1, 2, 3, -3, 4 };
	    short[] array2 = { 1, 2, 3, -1, -2, -3 };
	    short[] array3 = { -1, -2, -3 };
	    short[] array4 = {};
	    short[] array5 = { 1, 2, 0, -2 };
	    
	    assertEquals((short)3, getMaxPositiveWithNegativeReflect(array1));
	    assertEquals((short)3, getMaxPositiveWithNegativeReflect(array2));
	    assertEquals((short)-1, getMaxPositiveWithNegativeReflect(array3)); 
	    assertEquals((short)-1, getMaxPositiveWithNegativeReflect(array4));
	    assertEquals((short)2, getMaxPositiveWithNegativeReflect(array5));
	}

	
}
