package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateParenthesis {
	
	private GenerateParenthesis() {
		
	}
	
	public static List<String> execute(int n) {
        // 动态规划，第i中状态时从第i - 1中状态前移来的
        // i - 1种状态又是由一系列括号对组成
        // 第i对括号可以加在任何一对括号对两边
        // 所以可以得出状态迁移函数
        // dp[i] = "(" + dp[k] + ")" + dp[i - k - 1];

        Map<Integer, List<String>> status = new HashMap<Integer, List<String>>();
        status.put(0, Arrays.asList(""));
        status.put(1, Arrays.asList("()"));
        for (int i = 2; i <= n; i++) {
            status.put(i, helper(i, status));
        }

        return status.get(n);
    }

    private static List<String> helper(int n, Map<Integer, List<String>> status)  {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            List<String> left = status.get(i);
            List<String> right = status.get(n - i - 1);
            for (String str1 : left) {
                for (String str2 : right) {
                    list.add("(" + str1 + ")" + str2);
                }
            }
        }
        return list;
    }

}
