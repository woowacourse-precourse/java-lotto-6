package lotto.utils;

import static lotto.constants.Rule.LOTTO_SIZE;
import static lotto.constants.Rule.MAX_LOTTO;
import static lotto.constants.Rule.MIN_LOTTO;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Generator {
    public static List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO.getValue(), MAX_LOTTO.getValue(), LOTTO_SIZE.getValue());
    }
}
