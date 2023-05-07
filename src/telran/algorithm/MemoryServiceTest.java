package telran.algorithm;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class MemoryServiceTest {
private static final long MGB = 1024 * 1024;
byte[] array;
	@Test
	@Disabled
	void test() {
		int size = MemoryService.getMaxAvailableSize();
		array = new byte[size];
		boolean flException = false;
		try {
			array = null;
			array = new byte[size + 1];
		} catch (OutOfMemoryError e) {
			flException = true;
		}
		assertTrue(flException);
	}
	@Test
	@Disabled
	void allocationMemoryTestWithGC() {
		Runtime runtime = Runtime.getRuntime();
		System.out.println("*************************************");
		System.out.println("Allocation memory map with GC");
		for(int i = 0; i < 10; i++){
			displayMemoryMap(runtime);
			long freeMemory = runtime.freeMemory();
			int size = freeMemory > Integer.MAX_VALUE ?
					Integer.MAX_VALUE : (int) freeMemory;
			byte[] array = new byte[size];
		}
		System.out.println("*************************************");
	}
	@Test
	void allocationMemoryTestNoGc() {
		List<byte[]> list = new ArrayList<>();
		Runtime runtime = Runtime.getRuntime();
		System.out.println("*************************************");
		System.out.println("Allocation memory map without GC");
		try {
			while(true) {
				displayMemoryMap(runtime);
				long freeMemory = runtime.freeMemory();
				int size = freeMemory > Integer.MAX_VALUE ?
						Integer.MAX_VALUE : (int) freeMemory;
				list.add(new byte[size]);
			}
		} catch (OutOfMemoryError e) {
			
		}
	}
	private void displayMemoryMap(Runtime runtime) {
		System.out.printf("free memory: %dM, total memory: %dM, maximal memory:"
				+ " %dM\n",
				runtime.freeMemory() / MGB, runtime.totalMemory() / MGB,
				runtime.maxMemory() / MGB);
		
	}

}