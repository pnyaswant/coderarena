package com.hacker.rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Map;

public class AmazonLUX {

	static ArrayList<Integer> IDsOfSongs(int rideDuration, ArrayList<Integer> songDurations) {
		ArrayList<Integer> ids = new ArrayList<Integer>();
		int target = rideDuration - 30;
		Map<Integer, ArrayList<Integer>> durationToID = new TreeMap<Integer, ArrayList<Integer>>(
				Collections.reverseOrder());
		ArrayList<Integer> temp;
		for (int i = 0; i < songDurations.size(); i++) {
			if ((temp = durationToID.get(songDurations.get(i))) == null) {
				temp = new ArrayList<Integer>();
			}
			temp.add(i);
			durationToID.put(songDurations.get(i), temp);
		}

		Iterator iterator = durationToID.entrySet().iterator();
		Integer currDuration, reqDuration;
		ArrayList<Integer> tempIds;
		while (iterator.hasNext()) {
			Map.Entry entry = (Map.Entry) iterator.next();
			currDuration = (Integer) entry.getKey();
			reqDuration = target - currDuration;
			if (durationToID.containsKey(reqDuration)) {
				tempIds = (ArrayList) entry.getValue();
				if (currDuration != reqDuration || tempIds.size() > 1) {
					ids.add(durationToID.get(reqDuration).get(0));
					if (currDuration.equals(reqDuration)) {
						ids.add(durationToID.get(currDuration).get(1));
					} else {
						ids.add(durationToID.get(currDuration).get(0));
					}
					break;
				}
			}
		}
		Collections.sort(ids);
		return ids;
	}
	
	static ArrayList<Integer> IDsOfSongs2(int rideDuration, ArrayList<Integer> songDurations) {

		Map<Integer, Integer> map = new HashMap<>();
		int longSong = Integer.MIN_VALUE;
		ArrayList<Integer> result = new ArrayList<>();
		for (int i =0; i < songDurations.size(); i++ ) {
			Integer thisSong = songDurations.get(i);
			Integer otherSong = rideDuration - 30 - thisSong;
			if (map.containsKey(otherSong) && longSong < Math.max(otherSong, thisSong) ) {
				longSong = Math.max(otherSong, thisSong);
				result = new ArrayList<>();
				result.add(map.get(otherSong));
				result.add(i); 
			}
			map.put(thisSong, i);
		}
		return result;
	}

	public static void main(String args[]) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(24);
		temp.add(1);
		temp.add(25);
		temp.add(36);
		temp.add(35);
		temp = AmazonLUX.IDsOfSongs2(90, temp);
		System.out.println(temp.get(0) + " " + temp.get(1));

	}

	public boolean isStringStartsWithUpperCase(String str) {
		if (str == null || str.isEmpty()) {
			return false;
		}
		return str.charAt(0) >= 'A' && str.charAt(0) <= 'Z' ? true : false;

	}

}
