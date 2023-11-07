package lotto.util;

import static lotto.domain.LottoConstants.LOTTO_LENGTH_CONSTRAINT;
import static lotto.domain.LottoConstants.LOTTO_NUMBER_RANGE_END;
import static lotto.domain.LottoConstants.LOTTO_NUMBER_RANGE_START;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class TestNumbersGenerator implements NumbersGenerator {

    public static List<Integer> create() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_RANGE_START.getValue(),
                LOTTO_NUMBER_RANGE_END.getValue(), LOTTO_LENGTH_CONSTRAINT.getValue());
    }

    public static List<Integer> create(List<Integer> numbers) {
        return numbers;
    }


}
