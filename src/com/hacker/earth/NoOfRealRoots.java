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

class NoOfRealRoots {
	public static void main(String args[]) throws Exception {
		// Scanner
		Scanner s = new Scanner(System.in);
		int tests = Integer.valueOf(s.nextLine());
        int res=0;
		for (int i = 0; i < tests; i++) {
			String[] data = s.nextLine().split(" ");
			int a = Integer.valueOf(data[0]);
			int b = Integer.valueOf(data[1]);
			int c = Integer.valueOf(data[2]);
			if(b*b > 4 * a*c) {
				res++;
			}
		}
		System.out.println(res);

	}

}
