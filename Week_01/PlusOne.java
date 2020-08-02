/**
 * @author xiaobing
 */
public class PlusOne {

    private PlusOne() {

    }

    /**
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * 解题思路： 该题比较简单，需要注意的是，加一后的进位问题，也就是(9 + 1)的情况。
     *           当需要进位的时候，则需要对前一位进行进位处理，直到不需要进位为止
     *           极端的情况是所有数组全部为9。则需要对数组进行扩张。
     *
     * @param digits 给定整数数组
     * @return 加一后的数组
     */
    public static int[] execute(int[] digits) {
        //重点关注进位的情况
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] = digits[i] + 1;
                return digits;
            }
        }
        // 数组中所有元素初始化为0
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }

}
