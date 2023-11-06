package lotto.util;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int COUNT = 6;

    private RandomNumberGenerator() {
    }

    public static List<Integer> generateRandomNumbers(int count) {
        return Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, COUNT);
    }
}
