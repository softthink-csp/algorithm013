import java.util.Arrays;

/**
 * 最小堆
 */
public class MinHeap<T extends Comparable<T>> {
	
	private Object[] elementData;
	private int size = 0;
	private int DEFAULT_CAPACITY = 10;
	private int capacity = DEFAULT_CAPACITY;
	
	public MinHeap() {
		elementData = new Object[capacity];
	}
	
	public MinHeap(int initCapacity) {
		if (initCapacity > 0) {
			elementData = new Object[capacity];
		} else {
			throw new IllegalArgumentException("Illegal capacity " + initCapacity);
		}
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void insert(T value) {
		if (size == capacity) {
			grow();
		}
		elementData[size] = value;
		heapifyUp(size);
		size++;
	}
	
	@SuppressWarnings("unchecked")
	public T delete() {
		T top = (T) elementData[0];
		elementData[0] = elementData[size - 1];
		size--;
		heapifyDown();
		elementData[size] = null;
		return top;
	}
	
	@SuppressWarnings("unchecked")
	private void heapifyDown() {
		T temp = (T) elementData[0];
		int index = 0;
		int minChildIndex = minChild(index);
		while(minChildIndex != index) {
			T child = (T) elementData[minChildIndex];
			if (temp.compareTo(child) <= 0) {
				break;
			}
			elementData[index] = child;
			index = minChildIndex;
			minChildIndex = minChild(index);

		}
		elementData[index] = temp;
	}
	
	@SuppressWarnings("unchecked")
	private int minChild(int index) {
		int left = 2 * index + 1;
		int right = 2 * index + 2;
		if (left >= size) {
			return index;
		} else if (right >= size){
			return left;
		} else {
			return ((T)elementData[left]).compareTo(((T)elementData[right])) < 0 ? left : right;
		}
	}
	
	@SuppressWarnings("unchecked")
	private void heapifyUp(int index) {
		T temp = (T) elementData[index];
		
		while(index > 0) {
			int parentIndex = parent(index);
			T parent = (T) elementData[parentIndex];
			if (temp.compareTo(parent) < 0) {
				elementData[index] = parent;
				index = parentIndex;
			} else {
				break;
			}
		}
		elementData[index] = temp;
	}
	
	private int parent(int index) {
		return (index - 1) / 2;
	}
	
	private void grow() {
		int newCapacity = capacity << 1;
		elementData = Arrays.copyOf(elementData, newCapacity);
		capacity = newCapacity;
	}

}
