/**
 * 剑指 Offer 49. 丑数
 * 
 * @author zxb
 *
 */
public class NthUglyNumber {
	
	private NthUglyNumber() {
		
	}
	
	/**
	 * 解题思路：
	 * 采用三指针法，分别记录乘以质因子2， 3， 5后大于当前丑数的丑数的位置。比较三个丑数的最小值，
	 * 即为最接近当前丑数的丑数，作为下一个丑数。需要注意的时，当多个值相同的时候，都需要将位置向前推进一位。
	 * @param n
	 * @return
	 */
	public int execute(int n) {
        int index = 0;
        int p2 = 0, p3 = 0, p5 = 0;
        int[] ugly = new int[n];
        ugly[0] = 1;
        while(index < n - 1) {
           int minVal = Math.min(Math.min(ugly[p2] * 2, ugly[p3] * 3), ugly[p5] * 5);
            if (minVal == ugly[p2] * 2) {
                p2++;
            }
            if (minVal == ugly[p3] * 3) {
                p3++;
            }
            if (minVal == ugly[p5] * 5) {
                p5++;
            }
            ugly[++index] = minVal;
        }
        return ugly[index];
    }

}
