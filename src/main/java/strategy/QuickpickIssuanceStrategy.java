package strategy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.Lotto;

public class QuickpickIssuanceStrategy implements IssuanceStrategy {
    private static final int START_LOTTO_NUMBER = 1;
    private static final int END_LOTTO_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;

    @Override
    public Lotto issue() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_LOTTO_NUMBER, END_LOTTO_NUMBER, LOTTO_COUNT);
        return Lotto.from(numbers);
    }
}
