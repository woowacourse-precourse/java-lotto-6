package lotto;

import static lotto.Constant.LOTTO_NUMBER_COUNT;
import static lotto.Constant.MAXIMUM_LOTTO_NUMBER;
import static lotto.Constant.MINIMUM_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator {
    public static Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER,
                LOTTO_NUMBER_COUNT);
        return new Lotto(numbers);
    }
}
