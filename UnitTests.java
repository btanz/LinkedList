package LinkedList;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class UnitTests {

	private static final int LONG_LIST_LENGTH =10; 

	LinkedList<String> stringList;
	LinkedList<Integer> emptyList;
	LinkedList<Integer> longerIntList;
	LinkedList<Integer> intList;
	
	/**
	 * Create some lists to run unit tests on.
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		intList = new LinkedList<Integer>();
		intList.add(13);
		intList.add(85);
		intList.add(42);
		
		stringList = new LinkedList<String>();
		stringList.add("A");
		stringList.add("B");
		
		emptyList = new LinkedList<Integer>();
		
		longerIntList = new LinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerIntList.add(i);
		}
	
		
	}

	
	/** 
	 * Test if the get method is working correctly.
	 */
	@Test
	public void testGet()
	{
		// Test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {	
		}
		
		// Test short list, first contents, then out of bounds
		assertEquals("Check first", "A", stringList.get(0));
		assertEquals("Check second", "B", stringList.get(1));
		
		try {
			stringList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
		try {
			stringList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
		// Test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerIntList.get(i));
		}
		
		// Test off the end of the longer array
		try {
			longerIntList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
		try {
			longerIntList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** 
	 * Test if the remove method is working correctly.
	 */
	@Test
	public void testRemove()
	{
		int a = intList.remove(0);
		assertEquals("Remove: check a is correct ",13 , a);
		assertEquals("Remove: check element 0 is correct ", (Integer)85, intList.get(0));
		assertEquals("Remove: check size is correct ", 2, intList.getSize());
		
		try{
			intList.remove(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
		try{
			stringList.remove(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
	}
	
	
	/** 
	 * Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 */
	@Test
	public void testAddEnd()
	{
        
		stringList.add("C");
		assertEquals("AddEnd: check size is correct", 3, stringList.getSize());
		assertEquals("AddEnd: check new value at end is correct", "C", stringList.get(stringList.getSize()-1));	
		
		try{
			stringList.add(-1, "F");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
		try{
			stringList.add(1, null);
			fail("Check setting null");
		}
		catch (NullPointerException e) {
		}	
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		stringList.add("C");
		assertEquals("Size: check size is correct", 3, stringList.getSize());
		stringList.remove(0);
		assertEquals("Size: check size is correct", 2, stringList.getSize());
		stringList.remove(0);
		stringList.remove(0);
		assertEquals("Size: check size is correct", 0, stringList.getSize());
		
		
		
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
		stringList.add(1, "C");
		assertEquals("AddAtIndex: check size is correct", 3, stringList.getSize());
		assertEquals("AddAtIndex: check new value is correct", "C", stringList.get(1));
		assertEquals("AddAtIndex: check previous value is correct", "A", stringList.get(0));
		assertEquals("AddAtIndex: check next value is correct", "B", stringList.get(2));
		
		intList.add(2, 98);
		assertEquals("AddAtIndex: check size is correct", 4, intList.getSize());
		assertEquals("AddAtIndex: check new value is correct", (Integer)98, (Integer)intList.get(2));
		assertEquals("AddAtIndex: check previous value is correct", (Integer)85, (Integer)intList.get(1));
		assertEquals("AddAtIndex: check next value is correct", (Integer)42, (Integer)intList.get(3));
		
		try{
			stringList.add(1, null);
			fail("Check setting null");
		}
		catch (NullPointerException e) {
		}
		
		try{
			stringList.add(5, "F");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
		stringList.set(1, "X");
		assertEquals("Set: check new value is correct", "X", stringList.get(1));
	
		try {
			emptyList.set(0, 1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		
		try {
			stringList.set(-2, "Y");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		
		try{
			stringList.set(1, null);
			fail("Check setting null");
		}
		catch (NullPointerException e) {
		}
		
		
		
	}	
}
