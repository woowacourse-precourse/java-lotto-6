package lotto.global.utils.generator;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.global.utils.constant.LottoNumberType;

import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(LottoNumberType.MIN_NUMBER_OF_RANGE.getValue(),
                LottoNumberType.MAX_NUMBER_OF_RANGE.getValue(), LottoNumberType.LENGTH_OF_LOTTO.getValue());
    }
}