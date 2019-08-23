package com.hacker.earth;

import java.util.*;

class BennyShouldPass {
	public static void main(String args[]) throws Exception {
		// Scanner
		Scanner s = new Scanner(System.in);
		int tests = Integer.valueOf(s.nextLine());

		for (int i = 0; i < tests; i++) {
			String[] data = s.nextLine().split(" ");
			long N = Long.valueOf(data[0]);
			long M = Long.valueOf(data[1]);
			long X = Long.valueOf(data[2]);
			long tot = (N+1)*X;
            String[] marks = s.nextLine().split(" ");
            long sum = 0;
            for(String mark : marks){
                sum+= Integer.valueOf(mark);
            }
            if(tot-sum > M ){
                System.out.println("Impossible");
            } else if(tot - sum < 0) {
                System.out.println("1");
            } else{
                System.out.println(tot-sum);
            }
		}

	}
}
