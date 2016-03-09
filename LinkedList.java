package LinkedList;

import java.util.AbstractList;


/** A linked list implementation with sentinels and double links.
 * 
 * @author Benjamin Tanz
 *
 * @param <E> Type of the elements stored in the linked list 
 */
public class LinkedList<E> extends AbstractList<E> {
	
	// the first and last (sentinel) nodes of the list
	ListNode<E> head;
	ListNode<E> tail;
	// the size of the list (number of nodes not counting the two sentinels)
	private int size;

	
	/** Create a new empty LinkedList */
	public LinkedList() {
		size = 0;
		head = new ListNode<E>();
		tail = new ListNode<E>();
		// Set pointers between the new nodes
		head.next = tail;
		tail.prev = head;
	}
	
	
	/**
	 * Appends an element to the end of the list
	 * @param element The element to append
	 */
	public boolean add(E element ) 
	{
		// Ensure correct content of element 
		checkElem(element);
		
		// Create and initialize element; set pointers
		ListNode<E> addNode;
		addNode = new ListNode<E>(element, tail.prev, tail);
		tail.prev.next = addNode;
		tail.prev = addNode;
		
		// Increment list size
		size++;
		
		return true;
	}

	
	/** Get the element at position index
	 * @param index The index of the element to be retrieved 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. 
	 */
	public E get(int index) 
	{
		// Check whether index is valid and throw exception if not
		checkIndex(index);
		
		// Retrieve beginning of the list and move from the to the required index
		// (Possible optimization: Begin from end of list and move backwards iff index > size / 2)
		ListNode<E> current;
		current = head.next;
		for (int i = 0; i < index; i++)
		{
			current = current.next;
		}
		
		// Return data value of the node at index
		return current.data;
	}

	
	/**
	 * Insert an element to the list at the specified index
	 * @param The index where the element should be inserted
	 * @param element The element to insert
	 */
	public void add(int index, E element ) 
	{
		// Check whether index is valid and throw exception if not
		checkIndexAdd(index);
		
		// Ensure correct content of element 
		checkElem(element);
		
		// Initialize and move forward to element at index
		ListNode<E> current;
		ListNode<E> addNode;
		current = head;
		for (int i = 0; i < index; i++)
		{
			current = current.next;
		}
		
		// Create new node and set pointers
		addNode = new ListNode<E>(element, current, current.next);
		current.next.prev = addNode;
		current.next = addNode;
		
		size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		return size;
	}

	/** 
	 * Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException Iff index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// Check whether index is valid and throw exception if not
		checkIndex(index);
		
		// Initialize and move forward to index
		ListNode<E> current;
		current = head;
		for (int i = 0; i < index; i++)
		{
			current = current.next;
		}
		
		// Retrieve data and adjust pointers such that the previous and next nodes point to each other
		E data = current.next.data;
		current.next.next.prev = current;
		current.next = current.next.next;
		
		size--;
		
		return data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// Check whether index is valid and throw exception if not
		checkIndex(index);
		
		// Ensure correct content of element 
		checkElem(element);
		
		// Initialize and move forward to index
		ListNode<E> current = head;
		E data;
		for (int i = 0; i < index; i++)
		{
			current = current.next;
		}
		
		// Store old value (to return) and replace with new value
		data = current.next.data;
		current.next.data = element;
		
		return data;
	}  
	
	/**
	 * Check whether an index is valid for retrieval or removal
	 * @param index The index to check
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	private void checkIndex(int index)
	{
		if (index < 0 || index > size - 1)
		{
			throw new IndexOutOfBoundsException("Index out of bounds.");
			
		}
	}
	
	/**
	 * Check whether an index is valid for adding elements
	 * @param index The index to check
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	private void checkIndexAdd(int index)
	{
		if (index < 0 || index > size)
		{
			throw new IndexOutOfBoundsException("Index out of bounds.");
		}
	}
	
	/**
	 * Check whether an element is null
	 * @param element The element to check
	 * @throws NullPointerException if the element is null
	 */
	private void checkElem(E element)
	{
		if (element == null)
		{
			throw new NullPointerException("Element can not be null.");
		}
	}
	
	/**
	 * Getter for list size
	 */
	public int getSize()
	{
		return size;
	}
	
}