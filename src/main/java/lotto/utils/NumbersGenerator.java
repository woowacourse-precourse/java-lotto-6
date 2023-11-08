package lotto.utils;

import static lotto.constants.Value.LOTTO_SIZE;
import static lotto.constants.Value.MAX_LOTTO_NUMBER;
import static lotto.constants.Value.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NumbersGenerator {
    public static List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER.get(), MAX_LOTTO_NUMBER.get(),
                LOTTO_SIZE.get()));
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }
}
