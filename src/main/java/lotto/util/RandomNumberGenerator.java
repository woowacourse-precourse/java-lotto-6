package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.constants.LottoSetting;

import java.util.List;

public class RandomNumberGenerator {
    public List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoSetting.LOTTO_NUMBER_RANGE_START.getNumber(),
                LottoSetting.LOTTO_NUMBER_RANGE_END.getNumber(), LottoSetting.LOTTO_WINNING_NUMBERS_COUNT.getNumber());
    }
}
