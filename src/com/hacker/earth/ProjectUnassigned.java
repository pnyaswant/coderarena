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

class ProjectUnassigned {
	public static void main(String args[]) throws Exception {
		// Scanner
		Scanner s = new Scanner(System.in);
		int tests = Integer.valueOf(s.nextLine());

		for (int i = 0; i < tests; i++) {
			int lines = Integer.valueOf(s.nextLine());
			int dev = 0;
			int res = 0;
			for (int ii = 0; ii < lines; ii++) {
				String l = s.nextLine();
				if ("New Project".equals(l)) {
					if (dev > 0) {
						dev--;
					} else {
						res++;
					}

				} else {
					dev += Integer.valueOf(l);
				}
			}
			System.out.println(res);
		}

	}

}
