package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator {
    private static final Integer MINIMUM_LOTTO_NUMBER = 1;
    private static final Integer MAXIMUM_LOTTO_NUMBER = 45;
    private static final Integer LOTTO_NUMBER_COUNT = 6;

    public static Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER,
                LOTTO_NUMBER_COUNT);
        return new Lotto(numbers);
    }
}
