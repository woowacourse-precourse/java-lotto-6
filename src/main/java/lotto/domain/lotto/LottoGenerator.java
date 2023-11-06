package lotto.domain.lotto;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.lotto.strategy.PickNumbersStrategy;

public class LottoGenerator {

    private final PickNumbersStrategy pickNumbersStrategy;

    public LottoGenerator(PickNumbersStrategy pickNumbersStrategy) {
        this.pickNumbersStrategy = pickNumbersStrategy;
    }

    public List<Lotto> generateByCount(int count) {
        return Stream.generate(this::generate)
                .limit(count)
                .toList();
    }

    public Lotto generate() {
        int minNumber = LottoConfig.MIN_NUMBER.getValue();
        int maxNumber = LottoConfig.MAX_NUMBER.getValue();
        int count = LottoConfig.NUMBERS_COUNT.getValue();
        List<Integer> numbers = pickNumbersStrategy.pickNumbers(minNumber, maxNumber, count);
        return new Lotto(numbers);
    }

}
