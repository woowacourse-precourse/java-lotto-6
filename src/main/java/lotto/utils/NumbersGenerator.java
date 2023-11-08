package lotto.utils;

import static lotto.constants.Value.LOTTO_SIZE;
import static lotto.constants.Value.MAX_LOTTO_NUMBER;
import static lotto.constants.Value.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class NumbersGenerator {
    public static List<Integer> randomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER.get(), MAX_LOTTO_NUMBER.get(),
                LOTTO_SIZE.get());
        Collections.sort(numbers);
        return numbers;
    }
}
