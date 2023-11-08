package lotto.service;

import java.util.List;

public class Swap {

    public static void swap(List<Integer> list, int j) {
        if (list.get(j) > list.get(j + 1)) {
            int temp = list.get(j);
            list.set(j, list.get(j + 1));
            list.set(j + 1, temp);
        }
    }
}
