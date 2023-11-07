package lotto.utils;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int QUANTITY = 6;

    private RandomNumberGenerator() {
    }

    public static List<Integer> pickUniqueNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, QUANTITY);
    }
}
