package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utils.GameRules;

import java.util.List;

public class LottoNumberGenerator {
    private LottoNumberGenerator() {
    }

    public static List<Integer> pickNumbers() {
        return Randoms.pickUniqueNumbersInRange(GameRules.START_RANGE.getValue(), GameRules.END_RANGE.getValue(), GameRules.NUMBERS_SIZE.getValue());
    }
}
