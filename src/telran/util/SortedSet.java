package telran.util;

public interface SortedSet<T> extends Set<T> {
	T first();
	T last();
	T celling(T key);
	T floor(T key);
}
