package com.hacker.earth;

import java.util.*;

class StringDivisibleBySix {
	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
        if((str.charAt(str.length()-1) - 'a' +1) % 2 != 0){
            System.out.println("NO"); return;
        }
        long val = 0;
        for(char c:str.toCharArray()){
            val+=(c-'a'+1);
        }
        if(val %3 ==0){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

	}
}
