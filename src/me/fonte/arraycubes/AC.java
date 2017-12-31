package me.fonte.arraycubes;
import java.util.LinkedList;

//The command-line testing and experimentation interface for ArrayCubes
public class AC {

	public static void main(String[] args) {
		//testSwap();
		//testFlipX();
		//testFlipY();
		//testGetYSlice();
		//testArrayDim();
		//testReverse();
		testMap();
	}

	private static void testSwap() {
		//Create and initialize an input to the swap method for 2D arrays
		ArrayWrapper<Integer> inputForSwap = new ArrayWrapper<Integer>();
		inputForSwap.data = new LinkedList<LinkedList<Integer>>();
	
		for(int i = 0; i < 5; i++) {
			inputForSwap.data.add(new LinkedList<Integer>());
		}
		
		//init the 2D array with some incremented values
		for(LinkedList<Integer> innerList : inputForSwap.data) {
			for(int counter = 0; counter < 5; counter++) {
				innerList.add(counter);
				System.out.print(counter + " ");
			}
			System.out.print("\n");
		}
		
		//create an output 2D array and perform the swap, collecting the results
		ArrayWrapper<Integer> outputFromSwap = new ArrayWrapper<Integer>();
		outputFromSwap = inputForSwap.swap();
		
		//test the "swapped" output (just display it)
		for(int i = 0; i < 5; i++) {
			for(int n = 0; n < 5; n++) {
				System.out.print(outputFromSwap.data.get(i).get(n) + " ");
			}
			System.out.print("\n");
		}
		
	}
	
	private static void testFlipX() {
		//Create and initialize an input to the flipX method for 2D arrays
		ArrayWrapper<Integer> inputForFlipX = new ArrayWrapper<Integer>();
		inputForFlipX.data = new LinkedList<LinkedList<Integer>>();
			
		for(int i = 0; i < 5; i++) {
			inputForFlipX.data.add(new LinkedList<Integer>());
		}
				
		//init the 2D array with some incremented values
		for(LinkedList<Integer> innerList : inputForFlipX.data) {
			for(int counter = 0; counter < 5; counter++) {
				innerList.add(counter);
				System.out.print(counter + " ");
			}
			System.out.print("\n");
		}
				
		//create an output 2D array and perform the swap, collecting the results
		ArrayWrapper<Integer> outputFromFlipX = new ArrayWrapper<Integer>();
		outputFromFlipX = inputForFlipX.flipX();
				
		//test the "swapped" output (just display it)
		for(int i = 0; i < 5; i++) {
			for(int n = 0; n < 5; n++) {
				System.out.print(outputFromFlipX.data.get(i).get(n) + " ");
			}
			System.out.print("\n");
		}
	}
	
	
	
	private static void testFlipY() {
		//Create and initialize an input to the flipX method for 2D arrays
		ArrayWrapper<Integer> inputForFlipY = new ArrayWrapper<Integer>();
		inputForFlipY.data = new LinkedList<LinkedList<Integer>>();
					
		for(int i = 0; i < 5; i++) {
			inputForFlipY.data.add(new LinkedList<Integer>());
		}
		
		int counter2 = 0;
		
		//init the 2D array with some incremented values
		for(LinkedList<Integer> innerList : inputForFlipY.data) {
			for(int counter = 0; counter < 5; counter++) {
				counter2++;
				innerList.add(counter2);
				System.out.print(counter2 + " ");
			}
			System.out.print("\n");
		}
		
		
		//create an output 2D array and perform the swap, collecting the results
		ArrayWrapper<Integer> outputFromFlipY = new ArrayWrapper<Integer>();
		outputFromFlipY = inputForFlipY.flipY();
						
		//test the "swapped" output (just display it)
		for(int i = 0; i < 5; i++) {
			for(int n = 0; n < 5; n++) {
				System.out.print(outputFromFlipY.data.get(i).get(n) + " ");
			}
			System.out.print("\n");
		}
		
		
		
	}
	
	
	private static void testGetYSlice() {
		//Create and initialize an input to the flipX method for 2D arrays
		ArrayWrapper<Integer> inputForGetYSlice = new ArrayWrapper<Integer>();
		inputForGetYSlice.data = new LinkedList<LinkedList<Integer>>();
							
		//init the inner lists
		for(int i = 0; i < 5; i++) {
			inputForGetYSlice.data.add(new LinkedList<Integer>());
		}
		
		//init the 2D array with some incremented values
		for(LinkedList<Integer> innerList : inputForGetYSlice.data) {
			for(int counter = 0; counter < 5; counter++) {
				innerList.add(counter);
				System.out.print(counter + " ");
			}
			System.out.print("\n");
		}
		
		//choose and set an x index to use in a y-axis slice, then run the method
		int xIndex = 2;
		LinkedList<Integer> output = inputForGetYSlice.getYSlice(xIndex);
		
		for(Integer thisVal : output) {
			System.out.print(thisVal + " ");
		}
		
	}
	
	private static void testArrayDim() {
		ArrayWrapper<Integer> testArrayWrap = new ArrayWrapper<Integer>();
		
		//set parameters and call the array dim method
		int xDim = 10;
		int yDim = 5;
		int defaultValue = 5;
		testArrayWrap = testArrayWrap.arrayDim(xDim, yDim, defaultValue);
		
		//output the results of the array dim
		for(LinkedList<Integer> innerArray: testArrayWrap.data) {
			for(int thisVal : innerArray) {
				System.out.print(thisVal + " ");
			}
			System.out.print("\n");
		}
	}
	
	
	private static void testReverse() {
		SingleArray<Integer> testIn = new SingleArray<Integer>();
		for(int i = 0; i < 10; i++) {
			testIn.data.add(i, i);
		}
		
		SingleArray<Integer> testOut = testIn.reverse();
		
		System.out.print("Original:\n");
		for(int thisVal : testIn.data) {			
			System.out.print(thisVal + " ");
		}
		System.out.print("\n");
		
		System.out.print("Reversed:\n");
		for(int thisVal : testOut.data) {			
			System.out.print(thisVal + " ");
		}
		System.out.print("\n");		
		
	}
	
	private static SingleArray testMap() {
		//create and init the input array
		SingleArray<Integer> testIn = new SingleArray<Integer>();
		
		for(int i = 0; i < 10; i++) {
			testIn.data.add(i, i * 2);
		}
		
		//call the test method, with a lambda that doubles the values of all input elements
		SingleArray<Integer> testOut = testIn.map((n) -> n*2);		
		
		System.out.print("Original:\n");
		for(int thisVal : testIn.data) {			
			System.out.print(thisVal + " ");
		}
		System.out.print("\n");
		
		System.out.print("Reversed:\n");
		for(int thisVal : testOut.data) {			
			System.out.print(thisVal + " ");
		}
		System.out.print("\n");
		
		return testOut;
	}
}
