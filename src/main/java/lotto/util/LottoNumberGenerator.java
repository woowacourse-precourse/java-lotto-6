package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoConstant;

import java.util.List;

public class LottoNumberGenerator {

    private LottoNumberGenerator() {}

    public static LottoNumberGenerator getInstance() {
        return new LottoNumberGenerator();
    }

    public List<Integer> makeLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LottoConstant.MIN_LOTTO_NUMBER_BOUND.getValue(),
                LottoConstant.MAX_LOTTO_NUMBER_BOUND.getValue(),
                LottoConstant.VALID_LOTTO_NUMBER_NUM.getValue());
        return numbers;
    }
}
