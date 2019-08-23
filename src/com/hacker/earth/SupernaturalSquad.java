package com.hacker.earth;

import java.util.*;

class SupernaturalSquad {
	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		int tests = Integer.valueOf(s.nextLine());

		for (int i = 0; i < tests; i++) {
			String[] data = s.nextLine().split(" ");
			int total = Integer.valueOf(data[0]);
			int group = Integer.valueOf(data[1]);
			res = 0;
			recursion(total, group);
			System.out.println(res);
		}

	}

	static long res;

	static void recursion(int total, int group) {
		if (total - group < 0) {
			return;
		}
		res++;
		for (int i = group; i <= total / 2; i++) {
			recursion(total - i, i);
		}
		return;

	}
}
