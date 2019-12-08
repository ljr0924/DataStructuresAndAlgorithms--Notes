package Algorithms;

public class QuickSort {

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static int pivot(int[] array, int start, int end) {
        int base = array[start];
        while(start < end) {
            while (start < end && array[end] >= base) {
                end--;
            }
            if (start < end) {
                swap(array, start, end);
                start++;
            }
            while (start < end && array[start] <= base) {
                start++;
            }
            if (start < end) {
                swap(array, start, end);
                end--;
            }
        }
        return end;
    }

    public static void sort(int[] array, int start, int end) {
        if (start < end) {
            int pivot = pivot(array, start, end);
            sort(array, start, pivot - 1);
            sort(array, pivot + 1, end);
        }
    }

    public static void output(int[] array) {
        for (int i : array) {
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args) {
        int[] a1 = {6,5,4,3,2,1};
        sort(a1, 0, a1.length - 1);
        output(a1);
    }

}
