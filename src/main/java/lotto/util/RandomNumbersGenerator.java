package lotto.util;

import static lotto.config.GameNumberConfig.LOTTO_NUMBER_COUNT;
import static lotto.config.GameNumberConfig.LOTTO_RANGE_MAX;
import static lotto.config.GameNumberConfig.LOTTO_RANGE_MIN;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumbersGenerator {
    private RandomNumbersGenerator() {
    }

    public static List<Integer> generateSortedRandomNumbers() {
        List<Integer> numbers =  Randoms.pickUniqueNumbersInRange(
                LOTTO_RANGE_MIN.getNumber(),
                LOTTO_RANGE_MAX.getNumber(),
                LOTTO_NUMBER_COUNT.getNumber()
        );
        numbers.sort(null);
        return numbers;
    }
}
