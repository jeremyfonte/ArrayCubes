package me.fonte.arraycubes.test;
import java.util.LinkedList;
import me.fonte.arraycubes.*;

//The command-line testing and experimentation interface for ArrayCubes
public class AC {

	public static void main(String[] args) {
		//testSwap();
		//testFlipX(true);
		//testFlipY();
		//testGetYSlice();
		//testArrayDim();
		//testReverse();
		//testMap();
		//testPad();
		//performance1();
		testTwoDimGenerator();
	}

	private static void testSwap(boolean printOut) {
		//Create and initialize an input to the swap method for 2D arrays
		ArrayWrapper<Integer> inputForSwap = new ArrayWrapper<Integer>();
		inputForSwap.initData();
	
		for(int i = 0; i < 5; i++) {
			inputForSwap.initInnerList();
		}
		
		//init the 2D array with some incremented values
		for(LinkedList<Integer> innerList : inputForSwap.getData()) {
			for(int counter = 0; counter < 5; counter++) {
				innerList.add(counter);
				if(printOut) {
					System.out.print(counter + " ");
				}
			}
			if(printOut) {
				System.out.print("\n");
			}
		}
		
		//create an output 2D array and perform the swap, collecting the results
		ArrayWrapper<Integer> outputFromSwap = new ArrayWrapper<Integer>();
		outputFromSwap = inputForSwap.swap();
		
		//test the "swapped" output (just display it)
		for(int i = 0; i < 5; i++) {
			for(int n = 0; n < 5; n++) {
				if(printOut) {
					System.out.print(outputFromSwap.getData().get(i).get(n) + " ");
				}
			}
			if(printOut) {
				System.out.print("\n");
			}
		}
		
	}
	
	private static void testFlipX(boolean printOut) {
		//Create and initialize an input to the flipX method for 2D arrays
		ArrayWrapper<Integer> inputForFlipX = new ArrayWrapper<Integer>();
		inputForFlipX.initData();
			
		for(int i = 0; i < 5; i++) {
			inputForFlipX.initInnerList();
		}
				
		//init the 2D array with some incremented values
		for(LinkedList<Integer> innerList : inputForFlipX.getData()) {
			for(int counter = 0; counter < 5; counter++) {
				innerList.add(counter);
				if(printOut) {
					System.out.print(counter + " ");
				}
			}
			
			if(printOut) {
				System.out.print("\n");
			}
		}
				
		//create an output 2D array and perform the swap, collecting the results
		ArrayWrapper<Integer> outputFromFlipX = new ArrayWrapper<Integer>();
		outputFromFlipX = inputForFlipX.flipX();
				
		//test the "swapped" output (just display it)
		for(int i = 0; i < 5; i++) {
			for(int n = 0; n < 5; n++) {
				if(printOut) {
					System.out.print(outputFromFlipX.getData().get(i).get(n) + " ");
				}
			}
			if(printOut) {
				System.out.print("\n");
			}
		}
	}
	
	
	
	private static void testFlipY(boolean printOut) {
		//Create and initialize an input to the flipX method for 2D arrays
		ArrayWrapper<Integer> inputForFlipY = new ArrayWrapper<Integer>();
		inputForFlipY.initData();
					
		for(int i = 0; i < 5; i++) {
			inputForFlipY.initInnerList();
		}
		
		int counter2 = 0;
		
		//init the 2D array with some incremented values
		for(LinkedList<Integer> innerList : inputForFlipY.getData()) {
			for(int counter = 0; counter < 5; counter++) {
				counter2++;
				innerList.add(counter2);
				if(printOut) {
					System.out.print(counter2 + " ");
				}
			}
			if(printOut) {
				System.out.print("\n");
			}
		}
		
		
		//create an output 2D array and perform the swap, collecting the results
		ArrayWrapper<Integer> outputFromFlipY = new ArrayWrapper<Integer>();
		outputFromFlipY = inputForFlipY.flipY();
						
		//test the "swapped" output (just display it)
		for(int i = 0; i < 5; i++) {
			for(int n = 0; n < 5; n++) {
				if(printOut) {
					System.out.print(outputFromFlipY.getData().get(i).get(n) + " ");
				}
			}
			if(printOut) {
				System.out.print("\n");
			}
		}	
	}
	
	
	private static void testGetYSlice(boolean printOut) {
		//Create and initialize an input to the flipX method for 2D arrays
		ArrayWrapper<Integer> inputForGetYSlice = new ArrayWrapper<Integer>();
		inputForGetYSlice.initData();
							
		//init the inner lists
		for(int i = 0; i < 5; i++) {
			inputForGetYSlice.initInnerList();
		}
		
		//init the 2D array with some incremented values
		for(LinkedList<Integer> innerList : inputForGetYSlice.getData()) {
			for(int counter = 0; counter < 5; counter++) {
				innerList.add(counter);
				if(printOut) {
					System.out.print(counter + " ");
				}
			}
			if(printOut) {
				System.out.print("\n");
			}
		}
		
		//choose and set an x index to use in a y-axis slice, then run the method
		int xIndex = 2;
		LinkedList<Integer> output = inputForGetYSlice.getYSlice(xIndex);
		
		for(Integer thisVal : output) {
			if(printOut) {
				System.out.print(thisVal + " ");
			}
		}
		
	}
	
	private static void testArrayDim(boolean printOut) {
		ArrayWrapper<Integer> testArrayWrap = new ArrayWrapper<Integer>();
		
		//set parameters and call the array dim method
		int xDim = 10;
		int yDim = 5;
		int defaultValue = 5;
		testArrayWrap = testArrayWrap.arrayDim(xDim, yDim, defaultValue);
		
		//output the results of the array dim
		for(LinkedList<Integer> innerArray: testArrayWrap.getData()) {
			for(int thisVal : innerArray) {
				if(printOut) {
					System.out.print(thisVal + " ");
				}
			}
			if(printOut) {
				System.out.print("\n");
			}
		}
	}
	
	
	private static void testReverse(boolean printOut) {
		SingleArray<Integer> testIn = new SingleArray<Integer>();
		for(int i = 0; i < 10; i++) {
			testIn.addDataIndex(i, i);
			
		}
		
		SingleArray<Integer> testOut = testIn.reverse();
		if(printOut) {
			System.out.print("Original:\n");
		}
		for(int thisVal : testIn.getData()) {			
			if(printOut) {
				System.out.print(thisVal + " ");
			}
		}
		
		if(printOut) {
			System.out.print("\n");
			System.out.print("Reversed:\n");
		}
		for(int thisVal : testOut.getData()) {			
			if(printOut) {
				System.out.print(thisVal + " ");
			}
		}
		if(printOut) {
			System.out.print("\n");
		}
		
	}
	
	private static void testMap(boolean printOut) {
		//create and init the input array
		SingleArray<Integer> testIn = new SingleArray<Integer>();
		
		for(int i = 0; i < 10; i++) {
			testIn.addDataIndex(i, i * 2);
		}
		
		//call the test method, with a lambda that doubles the values of all input elements
		SingleArray<Integer> testOut = testIn.map((n) -> n*2);		
		
		if(printOut) {
			System.out.print("Original:\n");
			for(int thisVal : testIn.getData()) {			
				System.out.print(thisVal + " ");
			}
			System.out.print("\n");
		
			System.out.print("Reversed:\n");
			for(int thisVal : testOut.getData()) {			
				System.out.print(thisVal + " ");
			}
			System.out.print("\n");
		}
	}
	
	public static void testPad() {
		//Create and initialize an input to the pad method for 2D arrays
		ArrayWrapper<Integer> inputForPad = new ArrayWrapper<Integer>();
		inputForPad.initData();
		
		for(int n = 0; n < 10; n++) {
			inputForPad.addListDataIndex(n, new LinkedList<Integer>());
			for(int rowVal = 0; rowVal < n; rowVal++) {
				inputForPad.addInnerDataIndex(n, rowVal, 5);
			}
		}
		
		inputForPad = inputForPad.pad(0);
	
		
		//output the results of the array dim
		for(LinkedList<Integer> innerArray: inputForPad.getData()) {
			for(int thisVal : innerArray) {
				System.out.print(thisVal + " ");
			}
			System.out.print("\n");
		}
	}
	
	private static void performance1() {
		//starting time
		long start = System.nanoTime();
		
		for(int n = 0; n < 10000; n++) {
			testSwap(false);
		}
		
		//finishing time
		long finish = System.nanoTime();
		
		//output elapsed time
		long timeDiff = (finish - start) / 1000000;
		System.out.println("time: " + timeDiff);
	}

	private static void testTwoDimGenerator() {
		ArrayWrapper<Integer> test = new ArrayWrapper<Integer>();
		test.initData();
		
		int countY = 0;
		for(int i = 0; i < 100; i += 10) {
			test.addListData(new LinkedList<Integer>());
			for(int n = 0; n < 10; n++) {
				test.addInnerDataIndex(countY, n, i + n);
			}
			countY++;
		}
		
		LinkedList<Integer> result = new LinkedList<Integer>();
		
		//
		//Does not currently support negative deltas, important to add support for them
		result = test.TwoDimGenerator(1, 1, 0, 0, 40);
		
		int resultSize = result.size();
		
		for(int n = 0; n < resultSize; n++) {
			System.out.print(result.get(n) + " ");
		}
	}

}
