package dsa.SortingAlgorithms;

import java.util.Arrays;

public class SortingMain {
    public static void main(String[] args) {
        int [] numbers = {1, 5, 7, 3, 9, 2, 4};
        BubbleSort.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
