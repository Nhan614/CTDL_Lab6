package task2;

import java.util.NoSuchElementException;

public class SinglyLinkedList<E> {
	private MyNode<E> head = null;
	private MyNode<E> tail = null;
	private int size;

	public SinglyLinkedList() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Returns the number of elements in the list.
	public int size() {

		return this.size;
	}
	// Returns true if the list is empty, and false otherwise.

	public boolean isEmpty() {
		return size == 0;
	}

	// Returns (but does not remove) the first element in the list.

	public E first() {
		if (isEmpty()) {
			throw new NoSuchElementException("Danh sach dang trong");
		}
		return head.getData();
	}

	// Returns (but does not remove) the last element in the list.

	public E last() {
		if (isEmpty()) {
			throw new NoSuchElementException("Danh sach dang trong");
		}
		return tail.getData();
	}

	// Adds a new element to the front of the list.
	public void addFirst(E e) {
		MyNode<E> newest = new MyNode<>(e);

		if (isEmpty()) {
			head = newest;
			tail = newest;
		} else {
			newest.setNext(head);
			head = newest;
		}
		size = size + 1;
	}

	// Adds a new element to the end of the list.
	public void addLast(E e) {
		MyNode<E> newest = new MyNode<>(e);

		if (isEmpty()) {
			head = newest;
			tail = newest;
		} else {
			newest.setNext(null);
			tail.setNext(newest);
			tail = newest;
		}
		size = size + 1;
	}

	// Removes and returns the first element of the list.
	public E removeFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException("Danh sach dang trong");
		}
		E firstRemove = head.getData();
		head = head.getNext();
		size = size - 1;
		return firstRemove;
	}

	// Removes and returns the last element of the list.
	public E removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException("Danh sach dang trong");
		}

		E lastRemove = tail.getData();
		if (size == 1) {
			head = null;
			tail = null;
		} else {
			MyNode<E> current = head;
			while (current != tail) {
				current = current.getNext();
			}
			current.setNext(null);
			;
			tail = current;
		}
		size = size - 1;
		return lastRemove;

	}

	public static void print(SinglyLinkedList<Integer> l) {

		if (l.head == null) {
			System.out.println("List is empty");
		} else {
			MyNode<Integer> temp = l.head;
			while (temp != null) {
				System.out.print(temp.getData());
				temp = temp.getNext();
				if (temp != null) {
					System.out.print("->");
				} else {
					System.out.println("");
				}
			}
		}
	}

	public static void main(String[] args) {

			SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
			list.addFirst(2);
			list.addLast(4);
			list.addFirst(8);
			list.addLast(5);
			list.addFirst(7);
			list.addLast(15);
			
			print(list);
			System.out.println("Kich thuoc cua danh sach:" + list.size());
			System.out.println("Phan tu dau tien trong danh sach:" + list.first());
			System.out.println("Phan tu cuoi cung trong danh sach:" + list.last());
			System.out.println("Xoa ptu dau tien trong danh sach:" + list.removeFirst());
			System.out.println("Xoa ptu cuoi cung trong danh sach" + list.removeLast());


	}
}
