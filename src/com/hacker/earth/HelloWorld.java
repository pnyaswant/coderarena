package com.hacker.earth;

public class HelloWorld {
	
	static Integer solution(Integer N) {
		Integer sol = 0;
		while(N/10>0) {
			if(sol.equals(0)) {
				sol = 1;
				continue;
			}
			sol = sol * 10;
			N = N/10;
		}
		return sol;
	}
			
	
	public static void main(String args[]) {
		System.out.println("1: " + HelloWorld.solution(1));
		System.out.println("2: " + HelloWorld.solution(2));
		System.out.println("3: " + HelloWorld.solution(3));
		System.out.println("9: " + HelloWorld.solution(9));
		System.out.println("10: " + HelloWorld.solution(10));
		System.out.println("11: " + HelloWorld.solution(11));
		System.out.println("12: " + HelloWorld.solution(12));
		System.out.println("99: " + HelloWorld.solution(99));
		System.out.println("100: " + HelloWorld.solution(100));
		System.out.println("123: " + HelloWorld.solution(123));
		System.out.println("200: " + HelloWorld.solution(200));
		System.out.println("4234: " + HelloWorld.solution(4234));
		System.out.println("72350: " + HelloWorld.solution(72350));
		System.out.println("823500: " + HelloWorld.solution(823500));
		System.out.println("9812350: " + HelloWorld.solution(9812350));
		
	}
}
