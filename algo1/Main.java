package algo1;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		int[] testArray = {2,8,6,5,4,7,3};
		int targetSum = 12;
		findPairs(testArray, targetSum);
	}
	/*
	 * 1. Create new Integer arraylist called sortedList
	 * 2. Loop through all indexes of array testArray
	 * 	  a. if sortedArray does not contain current index value, add it to the list
	 *    b. go to next index of the array
	 * 3. Sort the elements inside listA by numerical ascending order 
	 * 4. Create new String arraylist called duplicationChecker
	 * 5. Loop through all indexes of sortedList (Loop I)
		   	Inside loop, use nested Loop that loops through all indexes of sortedList (Loop II)
 * 		   	a. Create String that consists of current element value of Loop I, plus a comma, plus current element value of Loop II. (pair1)
 * 			b. Create String that consists of current element value of Loop II, plus a comma, plus current element value of Loop I. (pair2)
 * 			c. If current element value of Loop I + current element value of Loop II adds up to target sum, and if arraylist duplicationChecker does not contain 
 * 			   pair1 String (from a.) or pair2 String (from b.), print out pair1 String. Add pair1 String and pair2 String to duplicationChecker
 * 			d. go to next index of array (Loop II)
 *          e. after Loop II is finished, go to next index of array (Loop I)
 * 
	 */
	
	static void findPairs(int[] testArray, int targetSum) {
		// create new arraylist sortedList
		ArrayList<Integer> sortedList =  new ArrayList<>();
		
		// loop through every index of testArray, using int i to represent current element value
		for(int i : testArray) { 
			// if listA does not contain i, add i to listA
			if(!sortedList.contains(i)) { 
				sortedList.add(i);
			}
		}	
		// sort arraylist elements in numerical ascending order
		Collections.sort(sortedList);
//		System.out.println(sortedArray); 
		
		// create new arraylist duplicationChecker
		ArrayList<String> duplicationChecker = new ArrayList<>();
		
		// loop through every index of arraylist sortedList, using int i to represent current element value
		for(int i : sortedList) { 
			// nested; loop through every index of arraylist sortedList, using int j to represent current element value
			for (int j : sortedList) { 
				String pair1 = i + "," + j;
				String pair2 = j + "," + i;
				// if i + j equals targetSum, and duplicationChecker does not contain both pair1 and pair2, print out pair1, then add pair1 and pair2 to duplicationChecker.
				if (i + j == targetSum && !duplicationChecker.contains(pair1) && !duplicationChecker.contains(pair2)) {
					System.out.println(pair1);
					duplicationChecker.add(pair1);
					duplicationChecker.add(pair2);
				}
			}
		}	
    }
}
		

