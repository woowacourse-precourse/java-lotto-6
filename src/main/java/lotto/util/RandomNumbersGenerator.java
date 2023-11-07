package lotto.util;

import static lotto.config.GameNumberConfig.LOTTO_NUMBER_COUNT;
import static lotto.config.GameNumberConfig.LOTTO_RANGE_MAX;
import static lotto.config.GameNumberConfig.LOTTO_RANGE_MIN;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumbersGenerator {
    private RandomNumbersGenerator() {
    }

    public static List<Integer> generateSortedRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LOTTO_RANGE_MIN.getValue(),
                LOTTO_RANGE_MAX.getValue(),
                LOTTO_NUMBER_COUNT.getValue()
        );
        List<Integer> sortedNumbers = new ArrayList<>(List.copyOf(numbers));
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }
}
