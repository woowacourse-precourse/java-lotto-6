package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class RandomLotto {

    private static final int RANDOM_NUM_START = 1;
    private static final int RANDOM_NUM_END = 45;
    private static final int RANDOM_NUM_LENGTH = 6;

    public List<Integer> generateNum() {
        return Randoms.pickUniqueNumbersInRange(RANDOM_NUM_START, RANDOM_NUM_END, RANDOM_NUM_LENGTH);
    }

    public List<Integer> listSort(List<Integer> noSortList) {
        List<Integer> listSort = new ArrayList<>(noSortList);
        Collections.sort(listSort);
        return listSort;
    }
}
