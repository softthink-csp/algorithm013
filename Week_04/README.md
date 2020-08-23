学习笔记
寻找半有序的数组中间无序的地方
使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方
半有序指的是一半有序，一半无序？还是如图只在当中的某一个位置无序？
前者应该无法使用二分查找，这里默认后者
    // 有序为升序
    public static int search(int[] nums) {
        if (nums == null  || nums.length == 1) {
            return -1;
        } 
        return search(nums, 0, nums.length - 1);
    }

    private static int search(int[] nums, int left, int right) {
		if (left > right) {
			return -1;
		}
        int mid1 = (right + left) / 2;
        if (mid1 == nums.length - 1) {
        	return -1;
        }
        int mid2 = mid1 + 1;
		// 如果逆序， 怎返回
        if (nums[mid1] > nums[mid2]) {
            return mid2;
        }
        if (nums[mid1] > nums[0]) {
        	return search(nums, mid2, right);
        } else {
        	return search(nums, left, mid1 - 1);
        }
    }
    public static void main(String[] args) {
    	System.out.println(search(new int[] {1, 5, 6}));
    	System.out.println(search(new int[] {5, 6, 1}));
    	System.out.println(search(new int[] {6, 1, 5}));
    }