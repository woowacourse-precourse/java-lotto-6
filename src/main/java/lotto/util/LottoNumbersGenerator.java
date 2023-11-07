package lotto.util;

import static lotto.util.Constant.LOTTO_MAX_RANGE;
import static lotto.util.Constant.LOTTO_MIN_RANGE;
import static lotto.util.Constant.LOTTO_NUMBERS_COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumbersGenerator {
    public static List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_RANGE, LOTTO_MAX_RANGE, LOTTO_NUMBERS_COUNT);
    }
}
