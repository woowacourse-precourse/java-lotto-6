package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class NumberGenerator {
    private static final int MIN_NUMBER_RANGE = 1;
    private static final int MAX_NUMBER_RANGE = 45;
    private static final int NUMBER_COUNT = 6;

    public static List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE,
                NUMBER_COUNT);

        sortNumbers(randomNumbers);

        return randomNumbers;
    }

    private static void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }
}
