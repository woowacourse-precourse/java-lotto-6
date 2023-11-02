package lotto.util;

import java.util.List;

public class Quicksort {
    private static int LOTTO_MIN_INDEX = 0;
    private static int LOTTO_MAX_INDEX = 5;
    public void sort(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        quickSort(list, LOTTO_MIN_INDEX, LOTTO_MAX_INDEX);
    }

    private void quickSort(List<Integer> list, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(list, left, right);
            quickSort(list, left, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, right);
        }
    }

    private int partition(List<Integer> list, int left, int right) {
        int pivot = list.get(right);
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (list.get(j) < pivot) {
                i++;
                swap(list, i, j);
            }
        }

        swap(list, i + 1, right);
        return i + 1;
    }

    private void swap(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
