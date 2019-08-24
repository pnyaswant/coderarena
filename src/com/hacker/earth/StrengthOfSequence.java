package com.hacker.earth;



/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
//import for Scanner and other utility classes
import java.util.*;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class StrengthOfSequence {
    public static void main(String args[]) throws Exception {
		// Scanner
		Scanner s = new Scanner(System.in);
		int tests = Integer.valueOf(s.nextLine());
		
		String [] input = s.nextLine().split(" ");
		
		long[] data = new long[tests];
		for (int ii = 0; ii < tests; ii++) {
			data[ii] = Long.valueOf(input[ii]);
		}
		Arrays.sort(data);
		int start = 0; 
		int end = data.length-1;
		long res = 0;
		while(start< end) {
			res+=Math.abs(data[start++] - data[end]);
			res+=Math.abs(data[start] - data[end--]);
		}
		res+=Math.abs(data[start]-data[0]);
		System.out.print(res);

	}

}
