// Name: Márk Lakatos-Tóth
// Class ID: 203
// Assignment 1
// Description: This file contains the class SimpleList and its methods
package assign1;

/**
 * Contains a list of integers of maximum length 10, with adding and removing functionality
 */
public class SimpleList{
	
	private int[] list;
	private int count;
	
	/**
	 *Constructor that initializes the list to be empty (no input parameter)
	 */
	public SimpleList() {
		list = new int[10];
		count = 0;
	}
	/**
	 *Takes a new integer as input  and adds the element to the start of the list, and shifts every other entry to the right by 1.
	 *If the list is already full, the last elements gets replaced with the one preceding it. 
	 */
	public void add(int newInt) {
		int shiftStart = count - 1;
		if (count == 10) {
			shiftStart--; // if list is full last element does not get shifted
		}
		
		for (int index = shiftStart; index >= 0 ; index--) {
			list[index+1] = list[index];
		}
		list[0] = newInt;
		if (count < 10) {
			count++;
		}
	}
	/**
	 *Takes an integer as input parameter and searches for the element with the specified value and shifts the remaining entries to the left to avoid empty entries.
	 *If there are multiple entries with the specified value, all of them get removed.
	 */
	public void remove(int removeValue) {
		boolean removed = false;
		for (int index = 0; index < count && removed ==false; index++) {
			if (list[index] == removeValue) { //remove value and shift other values left
				count--;
				for (int shiftIndex = index; shiftIndex < count; shiftIndex++) {
					list[shiftIndex] = list[shiftIndex+1];
				}
				
				index--; //step back once since all values have been shifted
				removed = true;
			}
			
		}
	}
	/**
	 *Returns the length of the list. (no input parameter)
	 */
	public int count() {
		return count;
	}
	/**
	 *Returns the string representation of the list, where elements are seperated by spaces. (no input parameter)
	 */
	public String toString() {
		String output = new String();
		
		if (count > 0) {
			output += list[0];
			for (int index = 1; index<count;index++) {
				output += " " + list[index];
			}
		}else {
			output = "";
		}
		return output;		
	}
	/**
	 *Takes an the search value integer as input and searches for the specified value and returns its index in the list.
	 *If there is no matching integer in the list, returns -1.
	 *If there are multiple instances, it returns the last location. 
	 */
	public int search(int searchValue) {
		int location = -1;
		for (int index = 0; index < count && location == -1;index++) {
			if (list[index] == searchValue) {
				location = index;
			}
		}
		return location;
	}
}