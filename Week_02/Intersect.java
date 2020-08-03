import java.util.Arrays;
/**
 * @author xiaobing
 */
public class Intersect {

    private Intersect() {

    }

    /**
     * 给定两个数组，计算它们的交集。
     * 方法一： 先遍历短数组，将数字出现得次数保存在哈希表中，
     * 然后遍历长数组，找到哈希表中存在的数值，每次将数值减一，直到次数为0。
     *
     * 方法二： 先将数组排序，然后采用双指针法，依次比较数组中的每个元素，
     * 数值较小的一方继续向下遍历。直到一方数组遍历完成。
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 交集
     */
    public static int[] execute(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;
        int minLength = Math.min(nums1.length, nums2.length);
        int[] result = new int[minLength];
        while(i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                result[k++] = nums1[i++];
                j++;
            }
        }
        return Arrays.copyOf(result, k);

    }

//    public static int[] execute(int[] nums1, int[] nums2) {
//        Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
//        for (int i = 0; i < nums1.length; i++) {
//            int value = nums1[i];
//            hash.put(value, hash.containsKey(value) ? hash.get(value) + 1 : 1);
//        }
//        int[] result = new int[Math.min(nums1.length, nums2.length)];
//        int j = 0;
//        for (int i = 0; i < nums2.length; i++) {
//            int value = nums2[i];
//            if (hash.containsKey(value) && hash.get(value) > 0) {
//                result[j++] = value;
//                hash.put(value, hash.get(value) - 1);
//            }
//        }
//        return Arrays.copyOf(result, j);
//    }

}
