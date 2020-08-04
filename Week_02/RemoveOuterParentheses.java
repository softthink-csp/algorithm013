public class RemoveOuterParentheses {

    private RemoveOuterParentheses() {

    }

    /**
     * 1021. 删除最外层的括号
     * 解题思路：
     * 这道题目解题思路没有什么特别讨巧的地方， 基本上是遍历一遍，找到原语，然后剥离外层括号，加入结果字符串。
     * 讨巧的地方在于如何剥离外层括号，基本上我实现了三个版本，
     * 第一个版本，采用List记录每次的所有找到的原语，然后对List遍历
     * 执行结果来看，比较慢
     * 第二个版本，不用List，直接在遍历的时候记录原语的起点和终点，遇到终点时，将剥离后的子串加入到结果字符串
     * 执行结果和第一个版本基本一致
     * 第三个版本，参考了其他人的代码，不记录原语的起点和终点，利用起点的括号数量为0， 终点为1的特性，遇到起点和终点就跳过。
     * 执行结果有了较大的提升
     *
     * @param S
     * @return
     */
    public static String execute(String S) {
        int count = 0;
        StringBuilder result = new StringBuilder();
        int start = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == ')') {
                count--;
            }
            if (count >= 1) {
                result.append(c);
            }
            if (c == '(') {
                count++;
            }
        }
        return result.toString();

    }
}
