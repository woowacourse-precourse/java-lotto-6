package lotto.domain.lotto;

import java.util.List;
import lotto.domain.lotto.strategy.PickNumbersStrategy;

public class LottoGenerator {

    public Lotto generate(PickNumbersStrategy pickNumbersStrategy) {
        int minNumber = LottoConfig.MIN_NUMBER.getValue();
        int maxNumber = LottoConfig.MAX_NUMBER.getValue();
        int count = LottoConfig.NUMBERS_COUNT.getValue();
        List<Integer> numbers = pickNumbersStrategy.pickNumbers(minNumber, maxNumber, count);
        return new Lotto(numbers);
    }

}
