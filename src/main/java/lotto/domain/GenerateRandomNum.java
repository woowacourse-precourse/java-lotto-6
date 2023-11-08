package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.utils.Constants.*;
import static lotto.utils.ErrorMessages.CHECK_NUMBER_IN_RANGE;

public class GenerateRandomNum {

    public static List<Integer> pickNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER_IN_RANGE, MAX_NUMBER_IN_RANGE, LOTTO_SIZE);
        checkNumberInRange(numbers);
        return numbers;
    }

    public static void checkNumberInRange(List<Integer> numbers) {
        for (int num : numbers) {
            if (num < MIN_NUMBER_IN_RANGE || num > MAX_NUMBER_IN_RANGE)
                throw new IllegalArgumentException(CHECK_NUMBER_IN_RANGE);
        }
    }
}
