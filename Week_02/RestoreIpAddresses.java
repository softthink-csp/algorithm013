package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
	
	private RestoreIpAddresses() {
		
	}
	
	/**
	 * 暴力解法，四次for循环，每一层循环表示获取一段的长度，然后剪枝
	 * 
	 * @param s
	 * @return
	 */
    public static List<String> execute(String s) {
        List<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                for (int k = 1; k < 4; k++) {
                    for (int l = 1; l < 4; l++) {
                        if (i + j + k + l == length) {
                            int num1 = Integer.valueOf(s.substring(0, i));
                            int num2 = Integer.valueOf(s.substring(i, i + j));
                            int num3 = Integer.valueOf(s.substring(i + j, i + j + k));
                            int num4 = Integer.valueOf(s.substring(i + j + k));
                            if (num1 < 256 && num2 < 256 && num3 < 256 && num4 < 256) {
                                sb.append(num1).append(".").append(num2).append(".").append(num3).append(".").append(num4);
                                if (sb.length() == length + 3) {
                                    result.add(sb.toString());
                                }
                                sb.setLength(0);
                            }

                        }
                    }
                }
            }
        }
        return result;
    }
}
