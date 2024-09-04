package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.function.UnaryOperator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.edu.uptc.structures.MyList;

class MyListTest {
	private MyList<String> list;

	@BeforeEach
	void setUpBeforeEach() throws Exception {
		list = new MyList<String>();
		list.add("juan");
		list.add("lola");
	}

	@Test
	void testSize() {
		assertEquals(2, list.size());
	}

	@Test
	void testIsEmpty() {
		MyList<String> list2 = new MyList<String>();
		assertEquals(true, list2.isEmpty());
	}

	@Test
	void testContains() {
		assertEquals(true, list.contains("lola"));
	}

	@Test
	void testIterator() {
		Iterator<String> iterator = list.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("juan", iterator.next());
		assertEquals("lola", iterator.next());
		

	}

	@Test
	void testToArray() {
		Object[] array = list.toArray();
		assertEquals("juan", array[0]);
	}

	@Test
	void testToArrayTArray() {
		String[] array = list.toArray(new String[list.size()]);
		assertEquals("lola", array[1]);
		Object[] array2 = list.toArray(new Object[list.size()]);
		assertEquals("lola", array2[1]);
	}

	@Test
	void testAddT() {
		list.add("laura");
		assertEquals(true, list.contains("laura"));
		assertEquals(3, list.size());
	}

	@Test
	void testRemoveObject() {
		list.remove("lola");
		assertEquals(false, list.contains("lola"));
	}

	@Test
	void testContainsAll() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("juan");
		names.add("lola");
		boolean actual = list.containsAll(names);
		assertEquals(true, actual);
		names.add("lulu");
		actual = list.containsAll(names);
		assertEquals(false, actual);
	}

	@Test
	void testAddAllCollectionOfQextendsT() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("juanita");
		names.add("lolita");
		list.addAll(names);
		assertEquals(true, list.contains("lolita"));
	}

	@Test
	void testAddAllIntCollectionOfQextendsT() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("juanita");
		names.add("lolita");
		list.addAll(1, names);
		assertEquals(true, list.get(1).equals("juanita"));
	}

	@Test
	void testRemoveAll() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("juan");
		list.removeAll(names);
		assertEquals(true, list.get(0).equals("lola"));
	}

	@Test
	void testRetainAll() {
		ArrayList<String> namesToRetain = new ArrayList<>();
		namesToRetain.add("lola");
		list.retainAll(namesToRetain);
		assertEquals(true, list.get(0).equals("lola"));
	}

	@Test
	void testClear() {
		list.clear();
		assertEquals(0, list.size());
	}

	@Test
	void testGet() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("juan");
		names.add("lola");
		names.add("juanita");
		names.add("tony");

		assertEquals("tony", names.get(3));
	}

	@Test
	void testSet() {
		list.set(0, "pedro");
		assertEquals("pedro", list.get(0));
	}

	@Test
	void testAddIntT() {
		list.add(2, "diana");
		assertEquals("diana", list.get(2));
	}

	@Test
	void testRemoveInt() {
		list.remove(1);
		assertFalse(list.contains("lola"));
	}

	@Test
	void testIndexOf() {
		assertEquals(0, list.indexOf("juan"));
	}

	@Test
	void testLastIndexOf() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("juan");
		names.add("carlos");
		names.add("sara");
		names.add("fernando");
		names.add("juan");

		assertEquals(4, names.lastIndexOf("juan"));
	}

	@Test
	void testListIterator() {
		ListIterator<String> iterator = list.listIterator();
		assertTrue(iterator.hasNext());
        assertEquals("juan", iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals("lola", iterator.next());

        assertFalse(iterator.hasNext());
      
        assertTrue(iterator.hasPrevious());
        assertEquals("lola", iterator.previous());

        assertTrue(iterator.hasPrevious());
        assertEquals("juan", iterator.previous());

        assertFalse(iterator.hasPrevious());
        
        iterator.next();
        iterator.remove();
        assertEquals(1, list.size());  
        
        iterator = list.listIterator();
        iterator.next();
        iterator.set("javier");
        assertEquals("javier", list.listIterator().next());

        
        iterator.remove();
        assertEquals(0, list.size()); 
        
        iterator.add("pablo");	
		assertEquals("pablo", list.get(list.size()-1));
	}

	@Test
	void testListIteratorInt() {
		ListIterator<String> iterator = list.listIterator(1);
		assertTrue(iterator.hasPrevious());
		assertEquals("juan", iterator.previous());

		assertTrue(iterator.hasNext());
        assertEquals("juan", iterator.next());

        assertTrue(iterator.hasNext());
              
        iterator.remove();
        assertEquals(1, list.size());  
        
        iterator = list.listIterator(0);
        iterator.next();
        iterator.set("javier");
        assertEquals("javier", list.listIterator().next());
        
        iterator.add("pablo");	
		assertEquals("pablo", list.get(list.size()-1));
	}

	@Test
	void testReplaceAll2() {
		UnaryOperator<String>changeToUpperCase = x -> x.toUpperCase();
		list.replaceAll2(changeToUpperCase);
		assertEquals("JUAN", list.get(0));
	}

	@Test
	void testSubList() {

		MyList<String> subList= (MyList<String>) list.subList(0, 1);

		assertEquals(true, subList.get(0).equals("juan"));

	}

	@Test
	void testDescendingIterator() {
		Iterator<String> iterator = list.descendingIterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("lola", iterator.next());
		assertEquals("juan", iterator.next());
	}
}
