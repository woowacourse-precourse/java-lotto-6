package lotto.application;

import static lotto.enums.LottoConfig.LOTTO_COUNT;
import static lotto.enums.LottoConfig.MAX_LOTTO_NUMBER;
import static lotto.enums.LottoConfig.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_NUMBER.getValue(), MAX_LOTTO_NUMBER.getValue(), LOTTO_COUNT.getValue()
        );
    }
}
