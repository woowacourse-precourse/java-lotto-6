package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator {
    public static List<Integer> generateUniqueNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoConstants.LOTTO_NUMBER_MIN, LottoConstants.LOTTO_NUMBER_MAX,
                LottoConstants.LOTTO_NUMBERS_COUNT);
    }
}
