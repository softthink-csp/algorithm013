package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 典型的回溯算法
 * 如果一个问题需要分几步解决，并每一步选择，
 * 对接下来的选择都会产生影响，那么就可以是否能够使用回溯算法来解决
 * @author bing5
 *
 */
public class LetterCombinations {
	
	private LetterCombinations() {
		
	}

	public static List<String> execute(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits == null || digits.equals("")) {
            return result;
        }
        Map<Character, String> map = new HashMap<Character, String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wzxy");

        StringBuilder sb = new StringBuilder();
        search(digits, 0, result, map, sb);
        
        return result;
    }

    private static void search(String digits, int deep, List<String> result, Map<Character, String> map, StringBuilder sb) {
        if (deep == digits.length()) {
            result.add(sb.toString());
            return;
        }

        String alphas = map.get(digits.charAt(deep));

        for(char alpha : alphas.toCharArray()) {
            sb.append(alpha);
            search(digits, deep + 1, result, map, sb);
            sb.setLength(sb.length() - 1);
        }
    }
}