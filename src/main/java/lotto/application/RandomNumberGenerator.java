package lotto.application;

import static lotto.domain.LottoConfig.LOTTO_COUNT;
import static lotto.domain.LottoConfig.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoConfig.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public List<Integer> generateNumbers(final int count) {
        return Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_NUMBER.getValue(), MAX_LOTTO_NUMBER.getValue(), LOTTO_COUNT.getValue()
        );
    }
}
