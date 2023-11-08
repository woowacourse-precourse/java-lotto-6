package lotto.util;

import static lotto.config.LottoConfig.LOTTO_NUMBER_AMOUNT_MAX;
import static lotto.config.LottoConfig.LOTTO_NUMBER_MAX;
import static lotto.config.LottoConfig.LOTTO_NUMBER_MIN;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator {
    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN.getValue(),
                LOTTO_NUMBER_MAX.getValue(), LOTTO_NUMBER_AMOUNT_MAX.getValue());
    }
}
