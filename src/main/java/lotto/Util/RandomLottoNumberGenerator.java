package lotto.Util;

import static lotto.config.LottoConfig.LOTTO_MAX_VALUE;
import static lotto.config.LottoConfig.LOTTO_MIN_VALUE;
import static lotto.config.LottoConfig.LOTTO_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoNumberGenerator {
    public static List<Integer> makeNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LOTTO_MIN_VALUE.getValue(), LOTTO_MAX_VALUE.getValue(), LOTTO_SIZE.getValue());
        List<Integer> mutableNumbers = new ArrayList<>(numbers);
        Collections.sort(mutableNumbers);

        return mutableNumbers;
    }
}
