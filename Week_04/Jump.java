package com.example.demo;

public class Jump {
	
	private Jump() {
		
	}
	
	/**
	 * 跳跃游戏 II
	 * 解题思路：贪心算法
	 * 
	 * @param nums
	 * @return
	 */
	public static int execute(int[] nums) {
        int step = 0;
        int max = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == end) {
                end = max;
                step++;
            }
        }
        return step;
    }
}
