package com.hacker.earth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MyLogger {

	public static void main(String[] args) throws Exception {
		List<Integer> list = new ArrayList<Integer>();
		list.add(-1);
		list.add(8);
		list.add(6);
		list.add(0);
		list.add(7);
		list.add(3);
		list.add(8);
		list.add(9);
		list.add(-1);
		list.add(6);
		/*
		 * list.add(1); list.add(3);
		 */
		System.out.println(minimumGroups(list));
	}

	public static int minimumGroups(List<Integer> predators) {
		int[] dp = new int[predators.size()];
		int max = 0;
		for (int i = 0; i < predators.size(); i++) {
			recursive(predators, i, dp);
		}

		for (int i : dp) {
			if (max < i)
				max = i;
		}
		return max;

	}

	static int recursive(List<Integer> predators, int index, int[] dp) {
		int temp = index;
		int result = 0;
		if(predators.get(temp) == -1) {
			dp[index] = 1;
			return 1;
		}
		result = 1 + recursive(predators, predators.get(index), dp);
		dp[index] = result;
		return result;

	}

	public static int solution(int A, int B) {
		// write your code in Java SE 8
		int result = 0;
		for (int i = A; i <= B; i++) {
			int sqrrt = (int) Math.sqrt(i);

			if (sqrrt * (sqrrt + 1) == i) {
				result++;
			}
		}
		return result;

	}

	public static int solution2(int A, int B) {
		// write your code in Java SE 8
		int result = 0;

		int sqrrt = (int) Math.sqrt(A);
		while (sqrrt * (sqrrt + 1) <= B) {
			if (sqrrt * (sqrrt + 1) >= A) {
				result++;
			}
			sqrrt++;
		}
		return result;
	}

	static String[] triangleOrNot(int[] a, int[] b, int[] c) {
		String[] result = new String[a.length];

		for (int i = 0; i < a.length; i++) {
			if (a[i] + b[i] > c[i] && c[i] + b[i] > a[i] && a[i] + c[i] > b[i]) {
				result[i] = "Yes";
			} else {
				result[i] = "No";
			}
		}
		return result;
	}

	public static int getMinimumUniqueSum(List<Integer> arr) {
		Collections.sort(arr);
		;
		int result = 0;
		int result2 = 0;
		int temp = 0;
		for (int val : arr) {
			result += Math.max(temp - val, 0);
			temp = Math.max(val, temp) + 1;
			result2 += temp;
		}
		return result2;
	}

	static int getIntergerComplement(int n) {

		int x = (int) (Math.log(n) / Math.log(2)) + 1;

		for (int i = 0; i < x; i++)
			n = (n ^ (1 << i));
		return n;
	}

	public static int deleteProducts(List<Integer> ids, int m) {

		Map<Integer, Integer> idVsCountMap = new HashMap();

		for (Integer id : ids) {
			if (idVsCountMap.containsKey(id)) {
				idVsCountMap.put(id, idVsCountMap.get(id) + 1);
			} else {
				idVsCountMap.put(id, 1);
			}
		}

		Map<Integer, LinkedList<Integer>> temp = new TreeMap();
		for (Entry<Integer, Integer> entry : idVsCountMap.entrySet()) {
			if (temp.get(entry.getValue()) != null) {
				temp.get(entry.getValue()).add(entry.getKey());
			} else {
				LinkedList<Integer> list = new LinkedList<Integer>();
				list.add(entry.getKey());
				temp.put(entry.getValue(), list);
			}
		}
		Iterator<Integer> it = temp.keySet().iterator();
		int i = 0;
		int result = 0;
		while (it.hasNext()) {
			Integer count = it.next();
			for (; i < m && (m - i) >= count; i += count) {
				LinkedList<Integer> ll = temp.get(count);
				if (ll.isEmpty()) {
					break;
				}
				ll.removeLast();
			}
			if (i == m || m - i < count) {
				LinkedList<Integer> ll = temp.get(count);
				result += ll.size();
			}
		}

		return result;

	}

	public static long listMax1(int n, List<List<Integer>> operations) {
		// Write your code here
		long arr[] = new long[n];
		int i, j = 0;
		for (i = 0; i < operations.size(); i++) {
			for (j = operations.get(i).get(0) - 1; j < operations.get(i).get(1) - 1; j++) {
				arr[j] += operations.get(i).get(2);
			}
		}
		long max = Long.MIN_VALUE;
		for (int k = 0; k < arr.length; k++) {
			if (max < arr[k]) {
				max = arr[k];
			}
		}
		return max;
	}

	public static long listMax(int n, List<List<Integer>> operations) {
		// Write your code here
		long arr[] = new long[n];
		int i, j = 0;
		long max = Long.MIN_VALUE;
		for (i = 0; i < operations.size(); i++) {
			arr[operations.get(i).get(0) - 1] += operations.get(i).get(2);
			if (operations.get(i).get(1) < n)
				arr[operations.get(i).get(1)] -= operations.get(i).get(2);
		}
		long temp = Long.MIN_VALUE;
		for (long a : arr) {
			temp += a;
			if (max > temp) {
				max = temp;
			}
		}
		return max;
	}

}
