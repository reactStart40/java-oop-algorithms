package telran.algorithm;

public class MemoryService {
public static int getMaxAvailableSize() {
	int right = Integer.MAX_VALUE;
	int left = 0;
	int middle = right / 2;
	int maxSize = 0;
	while (left <= right) {
		try {
			byte[] array = new byte[middle];
			maxSize = middle;
			left = middle + 1;
		} catch(OutOfMemoryError e) {
			right = middle - 1;
		}
		middle = right / 2 + left / 2;
	}
	return maxSize;
	
}
}