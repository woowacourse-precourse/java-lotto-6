package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.constant.LottoConstant;

public class RandomNumberGenerator {

    public List<Integer> generateUniqueNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoConstant.MIN_LOTTO_NUMBER_RANGE,
                LottoConstant.MAX_LOTTO_NUMBER_RANGE, LottoConstant.MAX_LOTTO_LENGTH);
    }
}
