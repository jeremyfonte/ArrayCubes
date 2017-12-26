/**
 * ArrayWrapper
 * This is the primary data structure for the ArrayCubes project.
 * It enhances a nested 2D LinkedList with methods for ArrayCubes' particular needs
 * 
 * @author Jeremy Fonte
 */


package me.fonte.arraycubes;
import java.util.LinkedList;
import java.util.UUID;


/**
 * This is the ArrayWrapper class, which houses the methods to create and manipulate 2D linked lists
 * 
 * @author Jeremy Fonte
 *
 * @param <T> A numeric class that fills the 2D LinkedList.
 */
public class ArrayWrapper<T extends Number> {
	public final String id = UUID.randomUUID().toString();
	
	//empty constructor
	public ArrayWrapper() {	}
	
	/**
	 * This constructor initializes the data field with the provided value
	 * 
	 * @param data The 2D LinkedList for this ArrayWrapper
	 */
	public ArrayWrapper(LinkedList<LinkedList<T>> data) {
		this.data = data;
	}
	
	//The actual 2D array data in a linked list 
	LinkedList<LinkedList<T>> data = new LinkedList<LinkedList<T>>();
	
	/**"flip" assumes the array is "even" or "rectangular", not a jagged array of arrays
	 * 
	 * @return Returns a new ArrayWrapper that has been flipped, columns for rows
	 */
	public ArrayWrapper<T> flip() {
		//check if the 2D array is jagged
		boolean isJagged = checkIfJagged();
		if(isJagged) {
			//throw error and cancel flip operation
		}
		
		ArrayWrapper<T> result = performFlip();
		
		return result;
	}
	
	/**Perform the operation of flipping the rows by columns to columns by rows
	 * 
	 * @return A new ArrayWrapper that's been flipped
	 */
	private ArrayWrapper<T> performFlip() {	
		
		LinkedList<LinkedList<T>> source = this.data;
		LinkedList<LinkedList<T>> dest = new LinkedList<LinkedList<T>>();

		
		//actually set the flipped values
		for(int i = 0; i < source.size(); i++) {
			//init the inner LinkedList<T> in the 2D array
			dest.add(i, new LinkedList<T>());
		}
		
		//actually set the flipped values
		for(int i = 0; i < source.size(); i++) {	
			//loop through the inner array and add the flipped values
			for(int n = 0; n < source.get(i).size(); n++) {
				//set the destination, flipped from the source
				dest.get(n).add(i, source.get(i).get(n));
			}
			
		}
		
		//set the result ArrayWrapper and return it, flipped
		ArrayWrapper<T> result = new ArrayWrapper<T>(dest);
		return result;
	}
	

	/**make sure the 2D list isn't a jagged array, which would complicate flipping it
	 * 
	 * @return Yes/No if the array is jagged.
	 */
	private boolean checkIfJagged() {		
		//check if the current array is jagged
		if(data.size() < 1 ) {
			return false;
		}
		int baselineY = data.get(0).size();
		for(LinkedList<T> l : data) {
			if (l.size() != baselineY) {
				return true; //jagged array - not all inner arrays are even by count
			}
		}
		return false; //not a jagged array
	}
}
