package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.LottoConstant;

import java.util.List;

public class NumberGenerator {
    public List<Integer> getLotteryRandomNumber() {
        int maxValue = LottoConstant.LOTTO_MAX_VALUE.getConstant();
        int minValue = LottoConstant.LOTTO_MIN_VALUE.getConstant();
        int lottoSize = LottoConstant.LOTTO_SIZE.getConstant();

        return Randoms.pickUniqueNumbersInRange(minValue, maxValue, lottoSize);
    }
}
