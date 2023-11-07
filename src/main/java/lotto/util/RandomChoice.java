package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.config.Config;

import java.util.List;

public class RandomChoice {
    public static List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(Config.LOTTO_MIN_VALUE, Config.LOTTO_MAX_VALUE,
                Config.LOTTO_TICKER_NUMBERS);
    }
}
