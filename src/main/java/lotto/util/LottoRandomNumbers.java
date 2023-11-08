package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.lotto.LottoRule;

import java.util.List;

public final class LottoRandomNumbers {

    private LottoRandomNumbers() {
    }

    public static List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoRule.START_NUMBER, LottoRule.END_NUMBER, LottoRule.NUMBER_MAX_SIZE.intValue());
    }
}
