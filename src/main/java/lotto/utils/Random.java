package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Random {
    private static final int LOTTO_RANGE_START = 1;
    private static final int LOTTO_RANGE_END = 45;
    private static final int LOTTO_COUNT = 6;

    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_RANGE_START, LOTTO_RANGE_END, LOTTO_COUNT);
    }
}
