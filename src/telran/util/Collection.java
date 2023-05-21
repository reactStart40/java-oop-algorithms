package telran.util;

import java.util.Arrays;
import java.util.function.Predicate;

public interface Collection<T> extends Iterable<T>{
boolean add(T obj);
int size();
boolean remove(T pattern);
default T[] toArray(T[] ar) {
	int size = size();
	if (ar.length < size) {
		ar = Arrays.copyOf(ar, size);
	}
	int index = 0;
	for(T obj: this) {
		ar[index++] = obj;
	}
	if (ar.length > size) {
		ar[size] = null;
	}

	return ar;
}
boolean removeIf(Predicate<T> predicate);
boolean contains(T pattern);
default  boolean isEqual(T object, T pattern) {

	return pattern == null  ? object == pattern : pattern.equals(object);
}
}