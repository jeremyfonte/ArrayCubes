/**
 * SingleArray
 * Functions for 1D arrays
 * 
 * 
 * @author Jeremy Fonte
 */

package me.fonte.arraycubes;
import java.util.LinkedList;

/**
 * 
 * @author Jeremy Fonte
 *
 * @param <T> A numeric class to fill the linked list
 */
public class SingleArray<T extends Number> {

	//init the data field
	LinkedList<T> data = new LinkedList<T>();
	
	//empty constructor
	public SingleArray() {};
	
	
	/**
	 * 
	 * @param input The linked list to reverse the order of
	 * @return A reversed copy of the input linked list
	 */	
	public SingleArray<T> reverse() {
		 int inputLen = this.data.size();
		 SingleArray<T> output = new SingleArray<T>();
		 
		 int n = 0;
		 for(int i = inputLen - 1; i >= 0; i--) {
			 output.data.add(n, this.data.get(i));
			 n++;
		 }
		 
		 return output;
	}
}
