package lotto.service;

import java.util.List;

public class BubbleSortService {
    public static void bubbleSort(List<Integer> list) {
        int randomNumberSize = list.size();
        for (int i = 0; i < randomNumberSize - 1; i++) {
            for (int j = 0; j < randomNumberSize - i - 1; j++) {
                SwapService.swap(list, j);
            }
        }
    }
}
