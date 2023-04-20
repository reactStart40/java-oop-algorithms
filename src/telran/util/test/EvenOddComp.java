
package telran.util.test;

import java.util.Comparator;

public class EvenOddComp implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		int res = Integer.compare(Math.abs(o1 % 2), Math.abs(o2 % 2)) ;
		if  (res == 0) {
			res = o1 % 2 == 0 ? Integer.compare(o1, o2) :
				Integer.compare(o2, o1);
		}
		return res;
	}

}