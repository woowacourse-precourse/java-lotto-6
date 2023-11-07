package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator {
    private LottoGenerator() {
    }

    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(
            NumberConstants.NUMBER_LEAST_VALUE.getValue(),
            NumberConstants.NUMBER_MOST_VALUE.getValue(),
            NumberConstants.NUMBER_COUNT.getValue()
        );
    }
}
