package lotto.util;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.domain.LottoConstants.LOTTO_LENGTH_CONSTRAINT;
import static lotto.domain.LottoConstants.LOTTO_NUMBER_RANGE_END;
import static lotto.domain.LottoConstants.LOTTO_NUMBER_RANGE_START;

import java.util.List;

public class RandomNumbersGenerator implements NumbersGenerator {

    public static List<Integer> create() {
        return pickUniqueNumbersInRange(LOTTO_NUMBER_RANGE_START.getValue(),
                LOTTO_NUMBER_RANGE_END.getValue(), LOTTO_LENGTH_CONSTRAINT.getValue());
    }
}
