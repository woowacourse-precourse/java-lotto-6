package lotto.strategy;

import static lotto.constants.LottoOption.END_LOTTO_NUMBER;
import static lotto.constants.LottoOption.LOTTO_COUNT;
import static lotto.constants.LottoOption.START_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.Lotto;

public class QuickpickIssuanceStrategy implements IssuanceStrategy {
    @Override
    public Lotto issue() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_LOTTO_NUMBER.getValue(),
                END_LOTTO_NUMBER.getValue(),
                LOTTO_COUNT.getValue());
        return Lotto.from(numbers);
    }
}
