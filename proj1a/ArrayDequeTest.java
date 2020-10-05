/** Performs some basic linked list tests. */
public class ArrayDequeTest {
	
	/* Utility method for printing out empty checks. */
	public static boolean checkEmpty(boolean expected, boolean actual) {
		if (expected != actual) {
			System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Utility method for printing out empty checks. */
	public static boolean checkSize(int expected, int actual) {
		if (expected != actual) {
			System.out.println("size() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Prints a nice message based on whether a test passed. 
	 * The \n means newline. */
	public static void printTestStatus(boolean passed) {
		if (passed) {
			System.out.println("Test passed!\n");
		} else {
			System.out.println("Test failed!\n");
		}
	}

	/** Adds a few things to the list, checking isEmpty() and size() are correct, 
	  * finally printing the results. 
	  *
	  * && is the "and" operation. */
	public static void addIsEmptySizeTest() {
		System.out.println("Running add/isEmpty/Size test.");
		System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

		ArrayDeque<String> lld1 = new ArrayDeque<String>();

		boolean passed = checkEmpty(true, lld1.isEmpty());
		passed = (lld1.removeFirst()==null) && passed;
		passed = (lld1.removeLast()==null) && passed;

		for (int i=0;i<10;i++)
			lld1.addLast("front");

		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
		passed = checkSize(10, lld1.size()) && passed;
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.addFirst("middle");
		passed = checkSize(11, lld1.size()) && passed;
		passed = (lld1.removeLast()=="front") && passed;
		passed = checkSize(10, lld1.size()) && passed;
		passed = (lld1.removeFirst()=="middle") && passed;
		passed = checkSize(9, lld1.size()) && passed;
//		lld1.printDeque();
		for (int i=0;i<10;i++)
			lld1.addLast("back");
		passed = checkSize(19, lld1.size()) && passed;

		for (int i=0;i<7;i++)
			lld1.addFirst("front1");
		passed = checkSize(26, lld1.size()) && passed;

		for (int i=0;i<3;i++)
			lld1.addLast("back1");
		passed = checkSize(29, lld1.size()) && passed;
		passed = (lld1.removeFirst()=="front1") && passed;
		passed = checkSize(28, lld1.size()) && passed;

		passed = (lld1.get(15)=="back") && passed;
		passed = (lld1.get(0)=="front1") && passed;

		System.out.println("Printing out deque: ");
		lld1.printDeque();
		System.out.println(lld1.removeFirst());

		ArrayDeque<String> lld2 = new ArrayDeque<String>();
		for (int i = 0;i<10000;i++)
			lld2.addLast("test123");
//		System.out.println(Sizeof.sizeof(lld2));
		for (int i = 0;i<9999;i++)
			lld2.removeFirst();
//		System.out.println(Sizeof.sizeof(lld2));
		System.out.println("Printing out deque: ");
		lld2.printDeque();

		ArrayDeque<Integer> lld3 = new ArrayDeque<Integer>();
//		for (int i = 0;i<100;i++)
//			lld3.addLast(i+15);
		lld3.addFirst(0);
		passed = checkEmpty(false, lld3.isEmpty());
		passed = (lld3.removeFirst()==0) && passed;
		lld3.addFirst(2);
		passed = checkEmpty(false, lld3.isEmpty());
		passed = (lld3.removeFirst()==2) && passed;
		passed = checkEmpty(true, lld3.isEmpty());

		ArrayDeque<Integer> lld4 = new ArrayDeque<Integer>();
		lld4.addLast(0);
		passed = (lld4.removeLast()==0) && passed;
		lld4.addLast(2);
		passed = (lld4.removeFirst()==2) && passed;
		passed = checkEmpty(true, lld4.isEmpty());
		lld4.addLast(5);
		lld4.addFirst(6);
		lld4.addLast(7);
		lld4.addFirst(8);
		passed = checkEmpty(false, lld4.isEmpty());
		passed = checkEmpty(false, lld4.isEmpty());
		passed = (lld4.removeLast()==7) && passed;

		printTestStatus(passed);

		System.out.println("Running performance test.");

		ArrayDeque<Integer> lld5 = new ArrayDeque<Integer>();
		for (int i=4;i<18;i++){
			for (int m=0; m<Math.pow(2,i);m++){
				lld5.addLast(m);
			}
			long startTime = System.nanoTime();
			for (int n=0; n<lld5.size();n++){
				lld5.removeFirst();
			}
			long endTime   = System.nanoTime();
			long totalTime = endTime - startTime;
			System.out.println(totalTime);
		}


	}

	/** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
	public static void addRemoveTest() {

		System.out.println("Running add/remove test.");

		System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

		ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
		// should be empty 
		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty 
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.removeFirst();
		// should be empty 
		passed = checkEmpty(true, lld1.isEmpty()) && passed;

		printTestStatus(passed);

	}

	public static void main(String[] args) {
		System.out.println("Running tests.\n");
		addIsEmptySizeTest();
		addRemoveTest();
	}
} 