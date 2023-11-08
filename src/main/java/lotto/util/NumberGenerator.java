package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.LottoConfiguration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberGenerator {

    public static List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();

        do {
            int number = Randoms.pickNumberInRange(LottoConfiguration.NUMBER_RANGE_START, LottoConfiguration.NUMBER_RANGE_END);
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        } while (numbers.size() < LottoConfiguration.NUMBERS_SIZE);

        Collections.sort(numbers);
        return numbers;
    }
}
