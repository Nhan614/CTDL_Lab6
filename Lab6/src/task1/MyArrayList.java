package task1;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<E> {
	public static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;

	public MyArrayList() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int capacity) {
		this.elements = (E[]) new Object[capacity];
	}

	// creates an array of double-size if the array of elements is full
	public void growSize() {
		if (elements.length == size) {
			E[] newelement = (E[]) new Object[elements.length * 2];
			System.arraycopy(elements, 0, newelement, 0, size);
			elements = newelement;
			System.out.println(elements.length);
		}
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E get(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		return elements[i];
	}

	public E set(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		E replacedElement = elements[i];
		elements[i] = e;
		return replacedElement;
	}

	public boolean add(E e) {
		if (size == elements.length) {
			growSize();
		}
		elements[size++] = e;
		return true;
	}

	public void add(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i > size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}

		if (size == elements.length) {
			growSize();
		}

		System.arraycopy(elements, i, elements, i + 1, size - i);
		elements[i] = e;
		size++;
	}

	public E remove(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}

		E removedElement = elements[i];
		System.arraycopy(elements, i + 1, elements, i, size - i - 1);
		elements[--size] = null; // Clear the last element
		return removedElement;
	}

	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}

	public int lastIndexOf(Object o) {
		for (int i = size - 1; i >= 0; i--) {
			if (o.equals(elements[i])) {
				return i;
			}
		}
		return -1;
	}

	public E[] toArray() {
		E[] array = (E[]) new Object[size];
		System.arraycopy(elements, 0, array, 0, size);
		return array;
	}

	public MyArrayList<E> clone() {
		MyArrayList<E> clonedList = new MyArrayList<>(size);
		clonedList.size = this.size;
		clonedList.elements = this.toArray();
		return clonedList;
	}

	public boolean contains(E o) {
		for (int i = 0; i < size; i++) {
			if (o.equals(elements[i])) {
				return true;
			}
		}
		return false;
	}

	public int indexOf(E o) {
		for (int i = 0; i < size; i++) {
			if (o.equals(elements[i])) {
				return i;
			}
		}
		return -1;
	}

	public boolean remove(E e) {
		for (int i = 0; i < size; i++) {
			if (e.equals(elements[i])) {
				remove(i);
				return true;
			}
		}
		return false;
	}

	public void sort(Comparator<E> c) {
		// You can use Arrays.sort or implement your own sorting algorithm here.
		Arrays.sort(elements, 0, size, c);
	}

	public static void main(String[] args) {
		MyArrayList<Integer> a1 = new MyArrayList<Integer>();
		a1.add(4);
		a1.add(3);
		a1.add(6);
		a1.add(2);
		a1.add(9);
		for (int i = 0; i < a1.size; i++) {
			System.out.print(a1.get(i));
			System.out.print("");

		}
		System.out.println();
		System.out.println("----------------------");
		System.out.println("get index 2: " +a1.get(2));
		System.out.println("Size: " +a1.size());
		System.out.println("----------------------");
		a1.add(2, 6);
		for (int i = 0; i < a1.size; i++) {
			System.out.print(a1.get(i));
		}
		System.out.println();
		System.out.println("----------------------");
		a1.remove(2);
		for (int i = 0; i < a1.size; i++) {
			System.out.print(a1.get(i));
		}
		System.out.println();
		System.out.println("----------------------");
		a1.sort(null);
		for (int i = 0; i < a1.size; i++) {
			System.out.print(a1.get(i));
		}
		System.out.println();
		System.out.println("index of: " + a1.indexOf(4));
		
	}
}