

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
	private LinkedList<LinkedList<T>> data = new LinkedList<LinkedList<T>>();
	
	//retrieve the data structure
	public LinkedList<LinkedList<T>> getData() {
		return this.data;
	}
	//set the entire data property at once
	public void setData(LinkedList<LinkedList<T>> data) {
		this.data = data; 
	}
	//init the whole data property - 2D linked list
	public void initData() {
		this.data = new LinkedList<LinkedList<T>>();
	}
	//init the inner list (linked list)
	public void initInnerList() {
		this.data.add(new LinkedList<T>());
	}
	//init the inner list with the provided linked list
	public void addListData(LinkedList<T> innerList) {
		this.data.add(innerList);
	}
	//init the inner list value to the provided list at a specific index
	public void addListDataIndex(int index, LinkedList<T> innerList) {
		this.data.add(index, innerList);
	}
	//add a new value to the data property's inner list
	public void addInnerData(int index, T innerVal) {
		this.data.get(index).add(innerVal);
	}
	//add a new value to the data property's inner list at a specified index
	public void addInnerDataIndex(int index, int innerIndex, T innerVal) {
		this.data.get(index).add(innerIndex, innerVal);
	}
	
	
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
	 * Flips a 2D array over the "x-axis", that is horizontally, i.e. reverses each inner array
	 * 
	 * @return The flipped 2D array
	 */
	public ArrayWrapper<T> flipX() {
		//source and destination linked lists for ArrayWrapper data
		LinkedList<LinkedList<T>> source = this.data;
		LinkedList<LinkedList<T>> dest = new LinkedList<LinkedList<T>>();
		
		//if there are no sub-lists abandon the operation
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
		
		//create the result ArrayWrapper with destination linked list data
		ArrayWrapper<T> result = new ArrayWrapper<T>(dest);
		return result;
	}
	
	//flip the order of the inner lists, i.e. flip over Y axis
	public ArrayWrapper<T> flipY() {
		//source and destination linked lists for ArrayWrapper data
		LinkedList<LinkedList<T>> source = this.data;
		LinkedList<LinkedList<T>> dest = new LinkedList<LinkedList<T>>();
		
		//if there are no sub-lists abandon the operation
		if(source.size() < 1) {
			//throw error
			return null;
		}

		for(int i = source.size() - 1; i >= 0; i--) {	
			dest.add(source.get(i));
		}
		
		//create the result ArrayWrapper with destination linked list data
		ArrayWrapper<T> result = new ArrayWrapper<T>(dest);
		return result;
	}
	
	/**
	 * generates a sequence in array form (2D)
	 * 
	 * @param seed The starting value of the sequence
	 * @param lambdaFunc The lambda function that acts on each iteration to generate the next value
	 * @param countElem The number of elements to generate
	 * @return The generated sequence in an array form
	 */
	/*
	public ArrayWrapper<T> generate(T seed, Predicate<T> lambdaFunc, int countElem, int xDimension) {
		LinkedList<LinkedList<T>> result = new LinkedList<LinkedList<T>>();
				
		//calculate the number of rows in the array
		int yDimension = (int)(countElem / xDimension);
		
		//main loop
		for(int i = 0; i < yDimension; i++) {
			result.add(new LinkedList<T>());
			
		}
		
		//create the ArrayWrapper to return
		ArrayWrapper<T> resultArray = new ArrayWrapper<T>(result);
		return resultArray;
	}
	*/
	
	
	/**
	 * Return a vertical slice of a 2D array - same X index for each Y list
	 * 
	 * @param source The source ArrayWrapper
	 * @param xIndex The xIndex of the vertical slice
	 * @return The LinkedList that holds the vertical array slice
	 */
	public LinkedList<T> getYSlice(int xIndex) {
		//extract the source data
		LinkedList<LinkedList<T>> sourceList = this.data;
		
		boolean indexFail = false; //if this is set to true the function exits
		
		//loop through the list and see if any rows are shorter than the xIndex variable
		for(LinkedList<T> thisList : sourceList) {
			int listLen = 0;
			
			listLen = thisList.size();
			if(xIndex >= listLen - 1) {
				indexFail = true;
				break;
			}
		}
		
		//if a row is too short return null/throw error
		if(indexFail) {
			//throw error
			return null;
		}
		
		//list for the elements of a y slice and the counter for the current index to save
		LinkedList<T> ySliceList = new LinkedList<T>();
		int sliceCounter = 0;
		
		//do the actually computation to perform a y-axis slice
		for(LinkedList<T> thisList : sourceList) {
			ySliceList.add(sliceCounter++, thisList.get(xIndex));
		}
		
		return ySliceList;
	}
	
	
	/**
	 * Create a new initialized 2D array of the specified dimensions, and fill it with a default value
	 * 
	 * @param xDim The x-dimension of the 2D array (inner list)
	 * @param yDim The y-dimension of the 2D array (outer list)
	 * @param defaultValue The value to fill the new 2D array elements with
	 * @return The initialized 2D array
	 */
	public ArrayWrapper<T> arrayDim(int xDim, int yDim, T defaultValue) {
		//create the ArrayWrapper and declare its nested linked lists
		this.data = new LinkedList<LinkedList<T>>();
		
		//cycle through the dimensions and initialize the elements
		for(int i = 0; i < yDim; i++) {
			this.data.add(new LinkedList<T>());
			
			for(int n = 0; n < xDim; n++) {
				this.data.get(i).add(null);
				this.data.get(i).set(n,  defaultValue);
			}
		}
		
		
		return this;
	}

	
	/**
	 * Modifies jagged arrays to become 2D rectangular arrays, padding new vals with the specified value
	 * 
	 * @param defaultValue The value to place in new vals
	 * @return The padded 2D array
	 */
	public ArrayWrapper<T> pad(T defaultValue) {
		LinkedList<LinkedList<T>> start = this.data;
		
		int maxLen = 0; //var that tracks the widest row
		
		//calculate widest row
		for(LinkedList<T> row : start) {
			int rowSize = row.size();
			if(rowSize > maxLen) {
				maxLen = rowSize;
			}
		}
		
		ArrayWrapper<T> output = new ArrayWrapper<T>();
		output.data = new LinkedList<LinkedList<T>>();
		
		int index = 0;
		
		//expand shorter rows by padding them with the default value
		for(LinkedList<T> row : start) {
			int rowSize = row.size();
			if(rowSize < maxLen) {
				int sizeDiff = maxLen - rowSize;
				for(int i = 0; i < sizeDiff; i++) {
					row.add(rowSize, defaultValue);
				}
			}
			
			output.data.add(index, row);
			index++;
		}
		
		return output;
	}
	
	/**
	 * Generates output by moving through a 2D array in a certain stepwise fashion
	 * 
	 * @param xDelta The change in x values on each iteration
	 * @param yDelta The change in y values on each iteration
	 * @param x The starting x value 
	 * @param y The starting y value
	 * @param count The number of iterations
	 * @return A linked list of the generated values
	 */
	public LinkedList<T> TwoDimGenerator(int xDelta, int yDelta, int x, int y, int count) {		
		int yDim = this.data.size();
		int xDim = 0; //initial value
		int xDimMax = 0; //just an initial value
		boolean notRect = false;
		
		//find the longest x dimension in 2D array
		for(int i = 0; i < yDim; i++) {
			xDim = this.data.get(i).size();
			if(xDim > xDimMax && xDimMax > 0) {
				notRect = true;
				xDimMax = xDim;
			}
		}
		
		//if the 2D array isn't rectangular, quit
		if(notRect) {
			//throw error
			return null;
		}
		
		LinkedList<T> output = new LinkedList<T>();
		
		for(int n = 0; n < count; n++) {
			output.add(n, this.data.get(y).get(x));
			
			x = (x + xDelta) % xDim;
			y = (y + yDelta) % yDim;
		}
		
		return output;
	}
}
