package lotto.service;

import static lotto.constants.LottoRule.LOTTO_MAX_SIZE;
import static lotto.constants.LottoRule.MAX_LOTTO_NUM;
import static lotto.constants.LottoRule.MIN_LOTTO_NUM;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange
                (MIN_LOTTO_NUM.getValue(), MAX_LOTTO_NUM.getValue(), LOTTO_MAX_SIZE.getValue());
    }
}
