package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.enums.LottoValue;

public class LottoNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generate() {
        int minNumberRange = LottoValue.MIN_LOTTO_NUMBER_RANGE.getValue();
        int maxNumberRange = LottoValue.MAX_LOTTO_NUMBER_RANGE.getValue();
        int numberCount = LottoValue.NUMBER_COUNT.getValue();
        return Randoms.pickUniqueNumbersInRange(minNumberRange, maxNumberRange, numberCount);
    }
}
