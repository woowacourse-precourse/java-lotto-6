package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import lotto.util.LottoConstants;

public class NumberGenerator {
    public static List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(LottoConstants.MIN_NUMBER_RANGE.getValue(),
                LottoConstants.MAX_NUMBER_RANGE.getValue(),
                LottoConstants.NUMBER_COUNT.getValue());

        sortNumbers(randomNumbers);

        return randomNumbers;
    }

    private static void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }
}
