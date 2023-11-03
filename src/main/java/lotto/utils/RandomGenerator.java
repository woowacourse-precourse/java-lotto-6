package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomGenerator {
    private static final int START = 1, END = 45, COUNT = 6;

    private RandomGenerator() {

    }

    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(START, END, COUNT);
    }
}
