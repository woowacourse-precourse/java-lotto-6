package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator {
    private final int MIN_NUMBER;
    private final int MAX_NUMBER;

    public RandomNumberGenerator(int minNumber, int maxNumber) {
        MIN_NUMBER = minNumber;
        MAX_NUMBER = maxNumber;
    }

    public List<Integer> generateRandomUniqueNumbers(int count) {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, count);
    }
}
