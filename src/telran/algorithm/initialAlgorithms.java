package telran.algorithm;
import telran.algorithm.*;
import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;


@SuppressWarnings("unused")
public class initialAlgorithms {
public static void sortShortPositive(short []array) {
	int []helper = new int [Short.MAX_VALUE];
	for(int i=0; i<array.length; i++) {
		helper[array[i]]++;
	}
	 int ind=0;
	for (int i=0; i<helper.length; i++) {
		for (int j=0; j<helper [i]; j++) {
			array[ind++]=(short) i;
		}
	}
}

public static boolean isSum2(short[] array, short sum) {
    Set<Short> set = new HashSet<>();
    for (short element : array) {
        if (set.contains((short)(sum - element))) {
            return true;
        }
        set.add(element);
    }
    return false;
}

public static void bubbleSort(short[] arr) {
    if (arr == null || arr.length == 0) {
        return;
    }

    boolean sorted = false;
    int lastSwapIndex = arr.length - 1;
    while (!sorted) {
        sorted = true;
        int tempIndex = lastSwapIndex;
        for (int i = 0; i < tempIndex; i++) {
            if (arr[i] > arr[i+1]) {
                short temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                sorted = false;
                lastSwapIndex = i;
            }
        }
    }
}


public static short getMaxPositiveWithNegativeReflect(short[] array) {
    bubbleSort(array);
    int maxPositive = -1;
    for (int i = 0; i < array.length; i++) {
        if (array[i] > 0 && Arrays.binarySearch(array, (short) -array[i]) >= 0) {
            if (maxPositive == -1 || array[i] > maxPositive) {
                maxPositive = array[i];
            }
        }
    }
    return (short) maxPositive;
}

}

