package telran.util;

import java.util.function.Predicate;

public interface Collection<T> extends Iterable<T> {
boolean add(T obj);
int size();
boolean remove(T pattern);
T[] toArray(T[] array);
boolean removeIf(Predicate<T> predicate);
boolean contains(T pattern);
default boolean isEqual(T object, T pattern) {

	return pattern == null  ? object == pattern : pattern.equals(object);
}
}