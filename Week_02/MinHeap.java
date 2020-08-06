import java.util.Arrays;

/**
 * 最小堆
 */
public class MinHeap {

    private int size = 0;
    private int[] elements;
    private int DEFAULT_CAPACITY = 10;
    int capacity = 0;

    public MinHeap() {
        this.capacity = DEFAULT_CAPACITY;
        elements = new int[capacity];
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(elements[i] + " ");
        }
    }

    public MinHeap(int capacity) {
        this.capacity = capacity;
        elements = new int[capacity];
    }

    public void insert(int value) {
        if (size == elements.length) {
            grow();
        }
        elements[size] = value;
        heapifyUp(size);
        size++;
    }

    public int delete() {
        int top = elements[0];
        elements[0] = elements[size - 1];
        heapifyDown(0);
        size--;
        return top;
    }

    private void heapifyDown(int i) {
        int temp = elements[i];

        while((2 * i + 1) < size) {
            int minChildIndex = minChild(i);
            if (elements[minChildIndex] >= temp) {
                break;
            }
            elements[i] = elements[minChildIndex];
            i = minChildIndex;
        }
        elements[i] = temp;
    }

    private void heapifyUp(int i) {
        int temp = elements[i];
        while(i > 0) {
            int parentIndex = parent(i);
            if (elements[parentIndex] <= temp) {
                break;
            } else {
                elements[i] = elements[parentIndex];
                i = parentIndex;
            }
        }
        elements[i] = temp;

    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int minChild(int i) {
        int leftIndex= child(i, 1);
        int rightIndex = child(i, 2);
        if (rightIndex >= size) {
            return leftIndex;
        }
        return elements[leftIndex] > elements[rightIndex] ? i * 2 + 2 : i * 2 + 1;
    }

    private int child(int i, int j) {
        return 2 * i + j;
    }

    private void grow() {
        int newCapacity = capacity << 1;
        elements = Arrays.copyOf(elements, newCapacity);
        capacity = newCapacity;
    }
}
