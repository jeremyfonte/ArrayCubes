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
	
	/**"swap" assumes the array is "even" or "rectangular", not a jagged array of arrays
	 * 
	 * @return Returns a new ArrayWrapper that has been swapped, columns for rows
	 */
	public ArrayWrapper<T> swap() {
		//check if the 2D array is jagged
		boolean isJagged = checkIfJagged();
		if(isJagged) {
			//throw error and cancel swap operation
			return null;
		}
		
		ArrayWrapper<T> result = performSwap();
		
		return result;
	}
	
	/**Perform the operation of swapping the rows by columns to columns by rows
	 * 
	 * @return A new ArrayWrapper that's been swapped
	 */
	private ArrayWrapper<T> performSwap() {	
		
		LinkedList<LinkedList<T>> source = this.data;
		LinkedList<LinkedList<T>> dest = new LinkedList<LinkedList<T>>();

		
		//init the swapped values
		for(int i = 0; i < source.size(); i++) {
			//init the inner LinkedList<T> in the 2D array
			dest.add(i, new LinkedList<T>());
		}
		
		//actually set the swapped values
		for(int i = 0; i < source.size(); i++) {	
			//loop through the inner array and add the swapped values
			for(int n = 0; n < source.get(i).size(); n++) {
				//set the destination, swapped from the source
				dest.get(n).add(i, source.get(i).get(n));
			}
			
		}
		
		//set the result ArrayWrapper and return it, swapped
		ArrayWrapper<T> result = new ArrayWrapper<T>(dest);
		return result;
	}
	

	/**make sure the 2D list isn't a jagged array, which would complicate swapping it
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
	
	/**
	 * Flips a 2D array over the "x-axis", that is horizontally
	 * 
	 * @return The flipped 2D array
	 */
	public ArrayWrapper<T> flipX() {
		LinkedList<LinkedList<T>> source = this.data;
		LinkedList<LinkedList<T>> dest = new LinkedList<LinkedList<T>>();
		
		if(source.size() < 1) {
			//throw error
			return null;
		}
		
		//init the LinkedList values
		for(int i = 0; i < source.size(); i++) {
			//init the inner LinkedList<T> in the 2D array
			dest.add(i, new LinkedList<T>());
		}
		
		//actually set the flipped values
		for(int i = 0; i < source.size(); i++) {	
			//loop through the inner array and add the flipped values
			int n2 = source.get(i).size() - 1;
			for(int n = 0; n < source.get(i).size(); n++, n2--) {
				//set the destination, flipped from the source
				dest.get(i).add(n, source.get(i).get(n2));
			}
			
		}
		
		ArrayWrapper<T> result = new ArrayWrapper<T>(dest);
		return result;
	}
	
}
