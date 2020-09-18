学习笔记

公共方法：
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
	}
冒泡排序：
	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		}
	}
	
选择排序：
	public static void selectSort(int[] arr) {	
		for (int i = 0; i < arr.length; i++) {
			int index = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[index] > arr[j]) {
					index = j;
				}
			}
			swap(arr, i, index);
		}	
	}

插入排序：
	public static void insertSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int val = arr[i];
			int index = i;
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] > val) {
					arr[j + 1] = arr[j];
					index = j;
				} else {
					break;
				}
			}
			arr[index] = val;
		}
	}

归并排序：
	public static void mergeSort(int[] arr) {
		sort(arr, 0, arr.length - 1);
	}
	
	private static void sort(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}
		// 根据数组大小使用 long 还是int
		int mid = (left + right) >> 1;
		sort(arr, left, mid);
		sort(arr, mid + 1, right);
		merge(arr, left, mid, right);
	}
	
	private static void merge(int[] arr, int left, int mid, int right) {
		int i = left, j = mid + 1;
		int length = right - left + 1;
		int[] temp = new int[length];
		int index = 0;
		while(i <= mid && j <= right) {
			temp[index++] = arr[i] > arr[j] ? arr[j++] : arr[i++];
		}
		
		while(i <= mid) temp[index++] = arr[i++];
		while(j <= right) temp[index++] = arr[j++];
		for (int p = 0; p < length; p++) {
			arr[left++] = temp[p];
		}
	}

快速排序：
	public static void quickSort(int[] arr, int left, int right) {
		if (left >= right) return;
		int index = partition(arr, left, right);
		quickSort(arr, left, index - 1);
		quickSort(arr, index + 1, right);
	}
	
	private static int partition(int[] arr, int left, int right) {
		int pivot = arr[right];
		int index = left;
		for (int i = left; i <= right; i++) {
			if (arr[i] < pivot) {
				swap(arr, i, index);
				index++;
			}
		}
		swap(arr, index, right);
		return index;
	}
