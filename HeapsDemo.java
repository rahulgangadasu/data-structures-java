package dsa;

import java.util.Arrays;

public class HeapsDemo {
    public static void main(String[] args) {
        var heap = new Heaps();
        heap.insert(10);
        heap.insert(29);
        heap.insert(7);
        heap.insert(14);
        heap.remove();
        heap.remove();
        heap.insert(6);
        heap.insert(9);
        System.out.println(heap);
        int [] numbers = {10, 4, 6 ,8 ,18, 27, 34, 7, 23};
        var heapSort = new Heaps();
        for (int items : numbers) {
            heapSort.insert(items);
        }
        for(int i = numbers.length - 1; i >=0; i--){
            numbers[i] = heapSort.remove();
        }
        System.out.println(Arrays.toString(numbers));
        MaxHeap.heapify(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println(MaxHeap.getKthLargest(numbers, 2));
    }
}
