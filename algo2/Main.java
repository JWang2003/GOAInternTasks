package algo2;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		int[] a = {1,3,5,3,4,5,9,-10};
		int[] b = {3,4,7,2,3,4};
		reconcileHelper(a, b);
	}
	
	/*
	 * 1. Create new Integer arraylist called listA
	 * 2. Loop through all indexes of array a
	 * 	  a. if listA does not contain current element value, add it to the list
	 *    b. go to next index of the array
	 * 3. Sort the elements inside listA by numerical ascending order 
	 * 4. Do steps 1-3 again but this time for array b (listB is created as arraylist)
	 * 
	 * 5. Create String compAtoB to contain the answer to be printed for "Numbers in array a that aren't in array b"
	 * 6. Loop through all indexes of arraylist listA
	 * 	  a. if listB does not contain current element value, add the value of i and a String space to compAtoB String
	 *    b. go to next index of the arraylist
	 * 7. Print out compAtoB
	 * 8. Do steps 5-7 again but this time for listB (answer String is compBtoA, comparing against listA)
	 */
	
	static void reconcileHelper(int[] a, int[] b) { 
		// create new arraylist listA
		ArrayList<Integer> listA = new ArrayList<>();
		// loop through every index of array b, using int i to represent current element value
		for(int i : a) { 
			// if listA does not contain i, add i to listA
			if(!listA.contains(i)) { 
				listA.add(i);
			}
			// head to next index of array a
		}
		// sort arraylist listA elements in numerical ascending order
		Collections.sort(listA);
		System.out.println(listA);
		
	
		// create new arraylist listB
		ArrayList<Integer> listB = new ArrayList<>();
		// loop through every index of array b, using int i to represent current element value
		for(int i : b) { 
			// if listB does not contain i, add i to listB
			if(!listB.contains(i)) { 
				listB.add(i);
			}
			// head to next index of array b
		}	
		// sort arraylist listB elements in numerical ascending order
		Collections.sort(listB);
		System.out.println(listB);
		
	
		//Create String compAtoB to answer "Numbers in array a that aren't in array b"
	    String compAtoB = "Numbers in array a that aren't in array b: ";
	    // loop through every index of listA, using int i to represent current element value
	    for (int i : listA) { 
	    	// if listB does not contain i, add i and space to answer String (compAtoB)
	    	if (!listB.contains(i)) { 
	    		compAtoB += i + " ";
	    	}
	    }
	    // prints out String compAtoB that answers the question "numbers in array a that aren't in array b"
	    System.out.println(compAtoB);
		
	    
	    //Create String compBtoA to answer "Numbers in array b that aren't in array b"
	    String compBtoA = "Numbers in array b that aren't in array a: ";
	    // loop through every index of listB, using int i to represent current element value
	    for (int i : listB) { 
	    	// if listA does not contain i, add i and space to answer String (compBtoA)
	    	if (!listA.contains(i)) { 
	    		compBtoA += i + " ";
	    	}
	    }
	    // prints out String compBtoA that answers the question "numbers in array b that aren't in array a"
	    System.out.println(compBtoA);
	}
}
