package com.hacker.earth;

import java.math.BigInteger;

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

class MagicalCandyBars {
    public static void main(String args[]) throws Exception {
		// Scanner
		Scanner s = new Scanner(System.in);
		int tests = Integer.valueOf(s.nextLine());

		for (int ii = 0; ii < tests; ii++) {
			String[] data = s.nextLine().split(" ");
			int bags = Integer.valueOf(data[0]);
			int mins = Integer.valueOf(data[1]);
			TreeMap<Long, Integer> map = new TreeMap();
			
			for(String can : s.nextLine().split(" ")){
				
				if(map.containsKey(Long.valueOf(can))){
					map.put(Long.valueOf(can), map.get(Long.valueOf(can))+1);
				}else {
					map.put(Long.valueOf(can), 1);
				}
			    
			}
			BigInteger res = BigInteger.valueOf(0);
			for(int i = 0 ;i <mins;i++){
			    long val = map.lastKey();//.getKey();
			    if(map.get(val)== 1) {
			    	map.remove(val);
			    } else {
			    	map.put(val,  map.get(val)-1);//entry.setValue(entry.getValue()-1);
			    }
			    res.add(BigInteger.valueOf(val));
			    val = val/2;
			    if(map.containsKey(val)){
					map.put(val, map.get(val)+1);
				}else {
					map.put(val, 1);
				}
			}
			System.out.println(res);
		}

	}

}
