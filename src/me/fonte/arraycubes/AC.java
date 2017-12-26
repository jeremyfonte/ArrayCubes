package me.fonte.arraycubes;
import java.util.LinkedList;

//The command-line testing and experimentation interface for ArrayCubes
public class AC {

	public static void main(String[] args) {
		testFlip();
	}

	private static void testFlip() {
		//Create and initialize an input to the flip method for 2D arrays
		ArrayWrapper<Integer> inputForFlip = new ArrayWrapper<Integer>();
		inputForFlip.data = new LinkedList<LinkedList<Integer>>();
	
		for(int i = 0; i < 5; i++) {
			inputForFlip.data.add(new LinkedList<Integer>());
		}
		
		//init the 2D array with some incremented values
		for(LinkedList<Integer> innerList : inputForFlip.data) {
			for(int counter = 0; counter < 5; counter++) {
				innerList.add(counter);
				System.out.print(counter + " ");
			}
			System.out.print("\n");
		}
		
		//create an output 2D array and perform the flip, collecting the results
		ArrayWrapper<Integer> outputFromFlip = new ArrayWrapper<Integer>();
		outputFromFlip = inputForFlip.flip();
		
		//test the "flipped" output (just display it)
		for(int i = 0; i < 5; i++) {
			for(int n = 0; n < 5; n++) {
				System.out.print(outputFromFlip.data.get(i).get(n) + " ");
			}
			System.out.print("\n");
		}
		
	}
}
