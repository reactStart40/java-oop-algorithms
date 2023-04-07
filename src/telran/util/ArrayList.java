package telran.util;

import java.util.Arrays;

public class ArrayList<T> implements List<T> {
	private static final int DEFAULT_CAPACITY = 16;
	private T[] array;
	private int size;

	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		array = (T[]) new Object[capacity];
	}

	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}

	@Override
	public boolean add(T obj) {
		if (size == array.length) {
			reallocate();
		}
		array[size] = obj;
		size++;
		return true;
	}

	private void reallocate() {
		array = Arrays.copyOf(array, array.length * 2);
	}

	@Override
	public void add(int index, T obj) {

		if (size == array.length) {
			reallocate();
		}
		System.arraycopy(array, index, array, index + 1, size - index);
		array[index] = obj;
		size++;
	}

	@Override
	public T remove(int index) {
		T removed = array[index];
		System.arraycopy(array, index + 1, array, index, size - index - 1);
		size--;
		return removed;
	}

	@Override
	public int size() {

		return size;
	}

	@Override
	public T get(int index) {
		return array[index];
	}

	@Override
	public boolean remove(T pattern) {
		int index = indexOf(pattern);
		return (index >= 0) ? remove(index) != null : false;
	}

	@Override
	public T[] toArray(T[] array) {
		int size = this.size;
		if (array.length < size) {
			T[] buffer = Arrays.copyOf(array, size);
			for (int i = 0; i < size; i++) {
				buffer[i] = this.get(i);
			}
			return buffer;
		} else {
			for (int i = 0; i < size; i++) {
				array[i] = this.get(i);
			}
			if (array.length > size) {
				array[size] = null;
			}
			return array;
		}
	}

	@Override
	public int indexOf(T pattern) {
		int res = -1;
		int index = 0;
		while (index < size && res == -1) {
			if (isEqual(array[index], pattern)) {
				res = index;
			}
			index++;
		}

		return res;
	}

	private boolean isEqual(T object, T pattern) {

		return pattern == null ? object == pattern : pattern.equals(object);
	}

	@Override
	public int lastIndexOf(T pattern) {
		int res = -1;
		int index = array.length - 1;
		while (index >= 0 && res == -1) {
			if (isEqual(array[index], pattern)) {
				res = index;
			}
			index--;
		}
		return res;
	}
}
