package lotto.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomListGenerator {
    public static final int MIN_RANDOM_BOUND = 1;
    public static final int MAX_RANDOM_BOUND = 45;
    public static final int TOTAL_COUNT = 6;

    public static List<Integer> generateNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_RANDOM_BOUND, MAX_RANDOM_BOUND, TOTAL_COUNT);
        return numbers;
    }
}