package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoNumConstant;

import java.util.List;

public class LottoNumberGenerator {

    private LottoNumberGenerator() {}

    public static LottoNumberGenerator getInstance() {
        return new LottoNumberGenerator();
    }

    public List<Integer> makeLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LottoNumConstant.MIN_LOTTO_NUMBER_BOUND.getValue(),
                LottoNumConstant.MAX_LOTTO_NUMBER_BOUND.getValue(),
                LottoNumConstant.VALID_LOTTO_NUMBER_NUM.getValue());
    }
}
