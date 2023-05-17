package telran.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public interface List<T> extends Collection<T> {
void add(int index, T obj);
T remove(int index);
T get(int index) ;
void sort(Comparator<T> comp);
int indexOf(Predicate<T> predicate);
int lastIndexOf(Predicate<T> predicate);

default  void sort() {
	sort((Comparator<T>)Comparator.naturalOrder());
}
@Override
 default public boolean remove(T pattern) {
	boolean res = false;
	int index = indexOf(pattern);
	if (index > -1) {
		res = true;
		remove(index);
	}
	return res;
}
@Override
default boolean contains(T pattern) {
	return indexOf(pattern)> -1;
}
default int indexOf(T pattern) {
	return indexOf(obj -> isEqual(obj, pattern));
}

default public T[] toArray(T[] ar) {
	int size =size();
	if (ar.length < size) {
		ar = Arrays.copyOf(ar, size);
	}
	for (int i=0; i<size; i++) {
	ar[i]=get(i);
	}
	if (ar.length > size) {
		ar[size] = null;
	}
	return ar;
}
default public int lastIndexOf(T pattern) {
	return lastIndexOf(obj -> isEqual(obj, pattern));
}

}