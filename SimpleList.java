// Name: Márk Lakatos-Tóth
// Class ID: 203
// Assignment 2
// Description: This file contains the class SimpleList and its methods
package cse360assign2;

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
	 *Takes an integer as input  and adds the element to the start of the list, and shifts every other entry to the right by 1.
	 *If the list is already full, its size is increased by 50%.
	 */
	public void add(int newInt) {
		int shiftStart = count - 1;
		if (count == list.length) {
			int newLength = list.length+list.length/2;
			int[] newList = new int[newLength];
			for (int index = 0; index <count;index++) {
				newList[index] = list[index];
			}
			list = newList;
		}
		
		for (int index = shiftStart; index >= 0 ; index--) {
			list[index+1] = list[index];
		}
		list[0] = newInt;
		count++;
	}
	/**
	 *Takes an integer as input and adds the element to the end of the list.
	 *If the list is already full, its size is increased by 50%.
	 */
	public void append(int newInt) {
		if (count == list.length) {
			int newLength = list.length+list.length/2;
			int[] newList = new int[newLength];
			for (int index = 0; index <count;index++) {
				newList[index] = list[index];
			}
			list = newList;
		}	
		count++;
		list[count-1] = newInt;
	}
	/**
	 *Takes an integer as input parameter and searches for the element with the specified value and shifts the remaining entries to the left to avoid empty entries.
	 *If there are multiple entries with the specified value, the first gets removed. 
	 *If the list has more than 25% empty places, the size of the list gets decreased by 25%
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
		int emptyEntries = list.length - count;
		if (1.0*emptyEntries/(1.0*list.length) > 0.25) { //multiplied by 1.0 to cast it to float 
			int newLength = list.length-list.length/4;
			int[] newList = new int[newLength];
			for (int index = 0; index <count;index++) {
				newList[index] = list[index];
			}
			list = newList;
					
		}
	}
	/**
	 *Returns the length of the list(count). (no input parameter)
	 */
	public int count() {
		return count;
	}
	/**
	 *Returns the string representation of the list, where elements are separated by spaces. (no input parameter)
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
	 *If there are multiple instances, it returns the first location. 
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
	/**
	 *Returns the first element(int) of the list (no input parameter). If there are no elements in the list, returns -1
	 */
	public int first() {
		if (count > 0){
			return list[0];
		}else {
			return -1;
		}
	}
	/**
	 *Returns the last element(int) of the list (no input parameter). If there are no elements in the list, returns -1
	 */
	public int last() {
		if (count > 0){
			return list[count-1];
		}else {
			return -1;
		}
	}
	/**
	 *Returns the length (int) of the list array, which is the current number of possible locations in the list. (no input parameter)
	 */
	public int size() {
		return list.length;
	}
}