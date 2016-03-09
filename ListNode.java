package LinkedList;


/** A node implementation for the linked list
 * 
 * @author Benjamin Tanz
 *
 * @param <E> Type of the elements stored in the list node
 */
public class ListNode<E> 
{
	// The previous and next nodes in the list
	ListNode<E> prev;    
	ListNode<E> next;
	// The data element of the node
	E data;

	/** 
	 * Create a new node using the standard constructor 
	 */ 
	public ListNode()
	{
		this.data = null;
		this.prev = null;
		this.next = null;
	}
	
	/** 
	 * Create a new node and initialize the data element
	 * @param e The data value of the node 
	 */
	public ListNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	/** 
	 * Create a new node and initialize the data element and the two pointers
	 * @param e The data value of the node
	 * @param prevNode The element of the previous node 
	 * @param nextNode The element of the next node  
	 */
	public ListNode(E e, ListNode<E> prevNode, ListNode<E> nextNode)
	{
		this.data = e;
		this.prev = prevNode;
		this.next = nextNode;
	}

}