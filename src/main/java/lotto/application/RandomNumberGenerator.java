package lotto.application;

import static lotto.domain.LottoConfig.LOTTO_COUNT;
import static lotto.domain.LottoConfig.LOTTO_MAX_NUMBER;
import static lotto.domain.LottoConfig.LOTTO_MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public List<Integer> generateNumbers(final int count) {
        return Randoms.pickUniqueNumbersInRange(
                LOTTO_MIN_NUMBER.getValue(), LOTTO_MAX_NUMBER.getValue(), LOTTO_COUNT.getValue()
        );
    }
}
