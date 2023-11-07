package lotto.Utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.Constants.IntConstants;

public class LottoGenerator {
    public static List<Integer> sixNumber() {
        return Randoms.pickUniqueNumbersInRange(IntConstants.MIN_RANGE.getValue(),
                IntConstants.MAX_RANGE.getValue(),
                IntConstants.LOTTO_NUMBER_COUNT.getValue());
    }
}
