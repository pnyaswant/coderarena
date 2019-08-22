package com.hacker.rank;

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

class TestClass {
	public static void main(String args[]) throws Exception {
		// Scanner
		Scanner s = new Scanner(System.in);
		int cities = Integer.valueOf(s.nextLine());
		Map<String, Integer> map = new HashMap<String, Integer>();
		String old = null;
		for (int i = 0; i < cities; i++) {
			String city = s.nextLine();
			if(i == 0 )old = city;
			map.put(city, i);
		}

		int[][] arr = new int[cities][cities];
		for (int i = 0; i < cities; i++) {
			String[] dist = s.nextLine().split(" ");
			for (int j = 0; j < cities; j++) {
				arr[i][j] = Integer.valueOf(dist[j]);
			}
		}

		int travel = Integer.valueOf(s.nextLine());
		String neww = null;
		int result = 0;
		for (int i = 0; i < travel; i++) {
			neww = s.nextLine();
			if (old != null) {
				result += arr[map.get(old)][map.get(neww)];
			}
			old = neww;

		}

		System.out.println(result); // Writing output to STDOUT

		// Write your code here

	}

	static void back(int a, int b, int c, int d, Set<String> result, String temp) {
		if (a == 0 && b == 0 && c == 0 && d == 0) {
			result.add(temp);
			return;
		}
		if (a > 0 && (temp.length() > 0 && temp.charAt(temp.length() - 1) != 'a' || temp.length() == 0))
			back(a - 1, b, c, d, result, temp + "a");
		if (b > 0 && (temp.length() > 0 && temp.charAt(temp.length() - 1) != 'b' || temp.length() == 0))
			back(a, b - 1, c, d, result, temp + "b");
		if (c > 0 && (temp.length() > 0 && temp.charAt(temp.length() - 1) != 'c' || temp.length() == 0))
			back(a, b, c - 1, d, result, temp + "c");
		if (d > 0 && (temp.length() > 0 && temp.charAt(temp.length() - 1) != 'd' || temp.length() == 0))
			back(a, b, c, d - 1, result, temp + "d");

	}
}
