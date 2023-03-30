package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ArrayListTest {

	@Test
	void testAdd() {
		ArrayList<Integer> numbers = new ArrayList<>();
		ArrayList<String> strings = new ArrayList<>();
		numbers.add(5);
		numbers.add(10);
		strings.add("ABC");
		assertEquals(2, numbers.size());
		assertEquals(1, strings.size());
	}
	@Test
	public void testAddIndex() {
	    ArrayList<Integer> list = new ArrayList<>();
	    
	    list.add(10);
	    list.add(20);
	    list.add(30);
	
	    list.add(0, 5); 
	    list.add(2, 15); 
	    list.add(5, 35); 
	    
	    assertEquals(Integer.valueOf(5), list.get(0));
	    assertEquals(Integer.valueOf(10), list.get(1));
	    assertEquals(Integer.valueOf(15), list.get(2));
	    assertEquals(Integer.valueOf(20), list.get(3));
	    assertEquals(Integer.valueOf(30), list.get(4));
	    assertEquals(Integer.valueOf(35), list.get(5));
	    
	    assertEquals(6, list.size());
	}
	
	    @Test
	    void testRemoveIndex() {
	        ArrayList<Integer> list = new ArrayList<>();
	        
	        list.add(1);
	        list.add(2);
	        list.add(3);
	        list.add(4);
	        list.add(5);
	       
	        assertEquals(Integer.valueOf(1), list.remove(0));
	        assertEquals(Integer.valueOf(3), list.remove(1));
	        assertEquals(Integer.valueOf(5), list.remove(list.size() - 1));
	    
	        assertEquals(Integer.valueOf(2), list.get(0));
	        assertEquals(Integer.valueOf(4), list.get(1));

	        assertEquals(2, list.size());
	    }
}
