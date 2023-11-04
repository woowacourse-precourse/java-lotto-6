package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumbersGenerator {

    private static final int MIN = 0;
    private static final int MAX = 9;

    private RandomNumbersGenerator() {
    }

    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(MIN, MAX, 6);
    }
}
