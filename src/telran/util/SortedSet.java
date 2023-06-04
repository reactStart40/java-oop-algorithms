package telran.util;

public interface SortedSet<T> extends Set<T> {
	T first();
	T last();
	T ceiling(T key);
	T floor(T key);
}