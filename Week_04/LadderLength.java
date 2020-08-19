package com.example.demo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 127. 单词接龙
 * 
 * @author bing5
 *
 */
public class LadderLength {

	private LadderLength() {

	}

	public static int execute(String beginWord, String endWord, List<String> wordList) {
		Set<String> visited = new HashSet<>();
		// 这里必须使用Set
		Set<String> allWord = new HashSet<>(wordList);
		Queue<String> queue = new LinkedList<String>();
		queue.add(beginWord);
		visited.add(beginWord);
		int step = 0;
		while (!queue.isEmpty()) {
			// 随着层数的增加，size有变得越来越大的风险，可以考虑从另一侧同时开始遍历，如果存在了交集，则说明已经找到
			int size = queue.size();
			step++;
			for (int i = 0; i < size; i++) {
				String top = queue.poll();
				if (top.equals(endWord)) {
					return step;
				}
				char[] chars = top.toCharArray();
				for (int j = 0; j < chars.length; j++) {
					char c0 = top.charAt(j);
					for (char c = 'a'; c <= 'z'; c++) {
						chars[j] = c;
						String newStr = new String(chars);
						if (visited.contains(newStr)) {
							continue;
						}
						if (allWord.contains(newStr)) {
							queue.add(newStr);
							visited.add(newStr);
						}
					}
					chars[j] = c0;
				}
			}
		}
		return 0;
	}
}
