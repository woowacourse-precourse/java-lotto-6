package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator {
    public static List<Integer> sixNumber() {
        return Randoms.pickUniqueNumbersInRange(IntConstants.MIN_RANGE.getValue(),
                IntConstants.MAX_RANGE.getValue(),
                IntConstants.LOTTO_NUMBER_COUNT.getValue());
    }

    public static int bonusNumber() {
        return Randoms.pickUniqueNumbersInRange(IntConstants.MIN_RANGE.getValue(),
                IntConstants.MAX_RANGE.getValue(),
                IntConstants.BONUS_NUMBER_COUNT.getValue()).get(0);
    }
}
