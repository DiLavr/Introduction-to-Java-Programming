package Chapter_24_Implementing_Lists_Stacks_Queues_and_Priority_Queues;

/**
 * Implement MyLinkedList
 * The implementations of the methods contains(E e), get(int index), indexOf(E e), lastIndexOf(E e), and set(int index, E e) are omitted in the text. Implement these methods.
 * 
 * 01/
 * @author kevgu
 *
 */

import java.util.*;

public class Programming_Exercise_02 {
	public static void main(String[] args) {
		new TestExercise_02();
	}

	public TestExercise_02() {
		String[] names = {"Tom", "Susan", "Kim", "George", "Peter", 
						"Jean", "George", "Jane", "Denise", "Jenny", "Kathy", "Jane"};
		MyLinkedList<String> list = new MyLinkedList<>(names);   

		Scanner input = new Scanner(System.in);
		System.out.print("Enter a name: ");
		String name = input.next();
    
		System.out.print("Enter an index: ");
		int index = input.nextInt();
		input.close();
    
		System.out.println(list.contains(name));
		System.out.println(list.get(3));
		System.out.println(list.indexOf(name));
		System.out.println(list.lastIndexOf(name));
		list.set(index, name);
    
		System.out.println(list);
    
		/* Uncomment the following lines to test Exercise 24.3 */
		//	java.util.ListIterator<Double> iterator1 = list.listIterator();
		//	while (iterator1.hasNext())
		//		System.out.print(iterator1.next() + " ");
		//      
		//	java.util.ListIterator<Double> iterator2 = list.listIterator(list.size() - 1);
		//	System.out.println();
		//	while (iterator2.hasPrevious())
		//		System.out.print(iterator2.previous() + " ");

	}


	public interface MyList<E> extends java.util.Collection<E> {
		/** Add a new element at the specified index in this list */
		public void add(int index, E e);

		/** Return the element from this list at the specified index */
		public E get(int index);

		/** Return the index of the first matching element in this list.
		 *  Return -1 if no match. */
		public int indexOf(Object e);

		/** Return the index of the last matching element in this list
		 *  Return -1 if no match. */
		public int lastIndexOf(E e);

		/** Remove the element at the specified position in this list
		 *  Shift any subsequent elements to the left.
		 *  Return the element that was removed from the list. */
		public E remove(int index);

		/** Replace the element at the specified position in this list
		 *  with the specified element and returns the new set. */
		public E set(int index, E e);
    
		@Override /** Add a new element at the end of this list */
		public default boolean add(E e) {
			add(size(), e);
			return true;
		}

		@Override /** Return true if this list contains no elements */
		public default boolean isEmpty() {
			return size() == 0;
		}

		@Override /** Remove the first occurrence of the element e 
		 			*  from this list. Shift any subsequent elements to the left.
		 			*  Return true if the element is removed. */
		public default boolean remove(Object e) {
			if (indexOf(e) >= 0) {
				remove(indexOf(e));
				return true;
			}
			else
				return false;
		}

		@Override
		public default boolean containsAll(Collection<?> c) {
			// Left as an exercise
			return false;
		}

		@Override
		public default boolean addAll(Collection<? extends E> c) {
			// Left as an exercise
			return false;
		}

		@Override
		public default boolean removeAll(Collection<?> c) {
			// Left as an exercise
			return false;
		}

		@Override
		public default boolean retainAll(Collection<?> c) {
			// Left as an exercise
			return false;
		}

		@Override
		public default Object[] toArray() {
			// Left as an exercise
			return null;
		}

		@Override
		public default <T> T[] toArray(T[] array) {
			// Left as an exercise
			return null;
		}
	}

	public class MyLinkedList<E> implements MyList<E> {
		private Node<E> head, tail;
		private int size = 0; // Number of elements in the list
    
		/** Create an empty list */
		public MyLinkedList() {
		}

		/** Create a list from an array of objects */
		public MyLinkedList(E[] objects) {
			for (int i = 0; i < objects.length; i++)
				add(objects[i]); 
		}

		/** Return the head element in the list */
		public E getFirst() {
			if (size == 0) {
				return null;
			}
			else {
				return head.element;
			}
		}

		/** Return the last element in the list */
		public E getLast() {
			if (size == 0) {
				return null;
			}
			else {
				return tail.element;
			}
		}

		/** Add an element to the beginning of the list
		 * 
		 * Needs modified for Exercise 24.3 */
		
		public void addFirst(E e) {
			Node<E> newNode = new Node<>(e); // Create a new node
			newNode.next = head; // link the new node with the head
			head = newNode; // head points to the new node
			size++; // Increase list size

			if (tail == null) // the new node is the only node in list
				tail = head;
		}

		/** Add an element to the end of the list
		 * 
		 * Needs modified for Exercise 24.3 */
		
		
		public void addLast(E e) {
			Node<E> newNode = new Node<>(e); // Create a new for element e

			if (tail == null) {
				head = tail = newNode; // The new node is the only node in list
			}
			else {
				tail.next = newNode; // Link the new with the last node
				tail = tail.next; // tail now points to the last node
			}

			size++; // Increase size
		}


		@Override /** Add a new element at the specified index 
		 			* in this list. The index of the head element is 0 
		 			* 
		 			* Needs modified for Exercise 24.3 */
		
		
		public void add(int index, E e) {
			if (index == 0) {
				addFirst(e);
			}
			else if (index >= size) {
				addLast(e);
			}
			else {
				Node<E> current = head;
				for (int i = 1; i < index; i++) {
					current = current.next;
				}
				Node<E> temp = current.next;
				current.next = new Node<>(e);
				(current.next).next = temp;
				size++;
			}
		}

		/** Remove the head node and
		 *  return the object that is contained in the removed node. 
		 *  
		 *  Needs modified for Exercise 24.3 */
		
		
		public E removeFirst() {
			if (size == 0) {
				return null;
			}
			else {
				Node<E> temp = head;
				head = head.next;
				size--;
				if (head == null) {
					tail = null;
				}
				return temp.element;
			}
		}

		/** Remove the last node and
		 * return the object that is contained in the removed node. */
		public E removeLast() {
			if (size == 0) {
				return null;
			}
			else if (size == 1) {
				Node<E> temp = head;
				head = tail = null;
				size = 0;
				return temp.element;
			}
			else {
				Node<E> current = head;

				for (int i = 0; i < size - 2; i++) {
					current = current.next;
				}

				Node<E> temp = tail;
				tail = current;
				tail.next = null;
				size--;
				return temp.element;
			}
		}

		@Override /** Remove the element at the specified position in this 
		 			*  list. Return the element that was removed from the list.
		 			*  
		 			*  Needs modified for Exercise 24.3 */
		
		
		public E remove(int index) {   
			if (index < 0 || index >= size) {
				return null;
			}
			else if (index == 0) {
				return removeFirst();
			}
			else if (index == size - 1) {
				return removeLast();
			}
			else {
				Node<E> previous = head;

				for (int i = 1; i < index; i++) {
					previous = previous.next;
				}

				Node<E> current = previous.next;
				previous.next = current.next;
				size--;
				return current.element;
			}
		}

		@Override /** Override toString() to return elements in the list */
		
		public String toString() {
			StringBuilder result = new StringBuilder("[");

			Node<E> current = head;
			for (int i = 0; i < size; i++) {
				result.append(current.element);
				current = current.next;
				if (current != null) {
					result.append(", "); // Separate two elements with a comma
				}
				else {
					result.append("]"); // Insert the closing ] in the string
				}
			}

			return result.toString();
		}

		@Override /** Clear the list */
		public void clear() {
			size = 0;
			head = tail = null;
		}

		@Override /** Return true if this list contains the element e */
		public boolean contains(Object o) {
			// Implement this for Exercise 24.2
			  if(size == 0) {
				   return false;
				  } else {
				   Node<E> temporary = head;
				   while(temporary != null) {
				    if(temporary.element.equals(o)) {
				     return true;
				    } else {
				     temporary = temporary.next;
				    }
				   }
				  }
				  return false;
				 }

		@Override /** Return the element from this list at the specified index */
		public E get(int index) {
			// Implement this for Exercise 24.2
				  checkIndex(index);
				  Node<E> result = head;
				  for (int i = 0; i < index; i++) {
				   result = result.next;
				  }
				  return result.element;
				 }

		@Override /** Returns the index of the first matching element in this list.
		 			*  Returns -1 if no match. */
		public int indexOf(Object o) {
			// Implement this for Exercise 24.2
			if(size == 0) {
				   return -1;
				  } else {
				   Node<E> temp = head;
				   int result = 0;
				   while(temp != null) {
				    if(temp.element.equals(o)) {
				     return result;
				    } else {
				     temp = temp.next;
				     result++;
				    }
				   }
				  }
				  return -1;
				 }

		@Override /** Returns the index of the last matching element in this list
		 			*  Returns -1 if no match. */
		public int lastIndexOf(Object o) {
			// Implement this for Exercise 24.2
			  if(size == 0) {
				   return -1;
				  } else {
				   Node<E> temp = head;
				   int result = 0;
				   int tmpresult = -1;
				   while(temp != null) {
				    if(temp.element.equals(o)) {
				     tmpresult = result;
				    }
				    temp = temp.next;
				    result++;    
				   }
				   return tmpresult;
				  }
				 }

		@Override /** Replace the element at the specified position in this list
		 *  with the specified element. */
		public E set(int index, E e) {
			// Implement this for Exercise 24.2
			  checkIndex(index);
			  Node<E> temp = head;
			  for (int i = 0; i < index; i++) {
			   temp = temp.next;
			  }
			  temp.element = e;
			  return e;
			 }

		@Override /** Override iterator() defined in Iterable */
		public java.util.Iterator<E> iterator() {
			return new LinkedListIterator();
		}
    
		public java.util.Iterator<E> iterator(int index) {
			return new LinkedListIterator(index);
		}
    
		// This should implement java.util.ListIterator for Exercise 24.3
		// ListIterator has additional methods:
		//    setLast()       -implement this
		//    add(E e)
		//    hasPrevious()   -implement this
		//    nextIndex()
		//    previous()      -implement this
		//    previousIndex()
		//    set(E e)        -implement this
		private class LinkedListIterator implements java.util.Iterator<E> {
			private Node<E> current = head; // Current index
      
			public LinkedListIterator() {
			}
      
			public LinkedListIterator(int index) {
				// Implement this for Exercise 24.3
			}
      
			@Override
			public boolean hasNext() {
				return (current != null);
			}

			@Override
			public E next() {
				E e = current.element;
				current = current.next;
				return e;
			}

			@Override
			public void remove() {
				// Left as an exercise
			}
		}
    
		private class Node<E> {
			// Needs modified for Exercise 24.3 
    	
			E element;
			Node<E> next;

			public Node(E element) {
				this.element = element;
			}
		}
    
		@Override /** Return the number of elements in this list */
		public int size() {
			return size;
		}
		 private void checkIndex(int index) {
			  if (index < 0 || index >= size)
			   throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
			 }
	}
}
