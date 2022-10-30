package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		this.head = new LLNode<E>(null);
		this.tail = new LLNode<E>(null, this.head);
		
		this.size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		
		if (element == null)
		{
			throw new NullPointerException("element is equal to null");
		}
			
		
		new LLNode<E>(element, this.tail.prev);
		
		size++;

		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if (index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException("MyLinkedList: Index "+index+" is invalid. List size is "+size);
		}
		return getNode(index).data;
	}
	
	private LLNode<E> getNode(int index)
	{
		  LLNode<E> current = head.next;
		  int i = 0;
		  while(current != tail && i < index)
		  {
			  current = current.next;
			  i++;
		  }
	     return current;
	  }

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if (index < 0 || index > size)
		{
			throw new IndexOutOfBoundsException("MyLinkedList: Index "+index+" is invalid. List size is "+size);
		}
		if(element == null) 
		{
			throw new NullPointerException("MyLinkedList: Null elements not permitted in List.");
		}
		LLNode<E> curr = getNode(index);
		new LLNode<E>(element, curr.prev);
		size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if (index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException("MyLinkedList: Index "+index+" is invalid. List size is "+size);
		}
		LLNode<E> current = getNode(index);
		
		current.next.prev = current.prev;

		current.prev.next = current.next;
		
		size--;
		
		return current.data;
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
		// TODO: Implement this method
		if (index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException("MyLinkedList: Index "+index+" is invalid. List size is "+size);
		}
		if (element == null)
		{
			throw new NullPointerException("MyLinkedList: Null elements not permitted in List.");
		}
		LLNode<E> current = getNode(index);
		E oldData = current.data;
		current.data = element;
	    return oldData;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	public LLNode(E e, LLNode<E> prevNode)
	{
		this(e);
		
		if(prevNode != null)
		{
			this.next = prevNode.next;
			if(this.next != null)
			{
			   (this.next).prev = this;
			}
			prevNode.next = this;
			this.prev = prevNode;
		}
	}

}
