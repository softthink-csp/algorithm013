import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    private GroupAnagrams() {

    }
    // 解法二，正整数的唯一分解定理，任意一个大于0的正整数都能被表示成若干个素数的乘积且表示方法是唯一的；
    // 整理可以将相同素数的合并；也就是将26个字母映射为不同的素数，如果不是字母异位词，则哈希值一定不养
    // 注意数组越界的问题
    public static List<List<String>> execute(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<Integer, List<String>> hash = new HashMap<Integer, List<String>>();
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
                31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79,
                83, 89, 97, 101};
        for (String str : strs) {
            char[] ca = str.toCharArray();
            int key = 1;
            for (char c : ca) {
                key = key * primes[c - 'a'];
            }
            if (hash.containsKey(key)) {
                hash.get(key).add(str);
            } else {
                hash.put(key, new ArrayList<String>(){{add(str);}});
            }
        }
        hash.forEach((key, value)-> result.add(value));
        return result;
    }

    // 解法一，先排序，然后作为key存入哈希表，异位词的key一定一致。
    // public List<List<String>> groupAnagrams(String[] strs) {
    //     List<List<String>> result = new ArrayList<List<String>>();
    //     Map<String, List<String>> hash = new HashMap<String, List<String>>();
    //     for (String str : strs) {
    //         char[] ca = str.toCharArray();
    //         Arrays.sort(ca);
    //         String key = String.valueOf(ca);
    //         if (hash.containsKey(key)) {
    //             hash.get(key).add(str);
    //         } else {
    //             hash.put(key, new ArrayList<String>(){{add(str);}});
    //         }
    //     }
    //     hash.forEach((key, value)-> result.add(value));
    //     return result;
    // }
}
