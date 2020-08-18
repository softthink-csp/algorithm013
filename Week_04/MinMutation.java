package com.example.demo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 最小基因变化
 * 
 * @author bing5
 *
 */
public class MinMutation {
	
	private MinMutation() {
		
	}
	
	/**
	 * 
	 * 思路：广度优先遍历，每一层需要遍历的元素都是bank
	 * 
	 * @param start
	 * @param end
	 * @param bank
	 * @return
	 */
    public static int execute(String start, String end, String[] bank) {
        Queue<String> queue = new LinkedList<String>();
        // 记录是否被遍历过
        int[] flag = new int[bank.length];
        queue.offer(start);
        int index = 0;
        int step = 0;
        int size = queue.size();
        while(!queue.isEmpty()) {
            // 记录当前层是否遍历完成，遍历完成之后，对下一层进行初始化，同时层数+1
            if (size == index) {
                size = queue.size();
                step++;
                index = 0;
            }
            index++;

            String top = queue.poll();
            if (top.equals(end)) {
                return step;
            }
            for (int i = 0; i < bank.length; i++) {
                if (flag[i] == 0) {
                    String current = bank[i];
                    if (compare(current, top)) {               
                        queue.offer(current);
                        flag[i] = 1;
                    }
                }
            }

        }
        return -1;
    }

    private static boolean compare(String str1, String str2) {
        int diff = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                diff++;
            }
        }
        if (diff == 1) {
            return true;
        } 
        return false;
    }

}
