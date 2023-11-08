package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.GameConstants;

import java.util.List;

public class LottoNumbersGenerator {
    public static List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(GameConstants.MIN_RANGE, GameConstants.MAX_RANGE,GameConstants.LOTTO_COUNT);
    }
}
