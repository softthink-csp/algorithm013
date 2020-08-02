/**
 * @author xiaobing
 */
public class RemoveDuplicates {

    private RemoveDuplicates() {
    }

    /**
     * 删除给定排序数组中的重复项，并返回新数组的长度
     *
     * 思路： 双指针法，指针j记录处理完不含重复项的下标位置，指针i记录遍历位置。
     *        遍历数组，如果当前值与指针j指向的值不一致的时候，将j指针前移，并将当前值复制到指针j所指向的位置
     *        最后由于下标从0开始，J+1返回。
     *        时间复杂度O(n)，空间复杂度O(1)
     *
     *
     * @param nums 待处理排序数组
     * @return 移除数组后的新长度
     */
    public static int execute(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[j] != nums[i]) {
                nums[++j] = nums[i];
            }
        }
        return ++j;
    }

}
