package lotto.domain;

import static lotto.domain.LottoConfig.*;

import java.util.List;
import lotto.strategy.NumberGenerationStrategy;

public class LottoGenerator {

    private final NumberGenerationStrategy numberGenerationStrategy;

    public LottoGenerator(NumberGenerationStrategy numberGenerationStrategy) {
        this.numberGenerationStrategy = numberGenerationStrategy;
    }

    public Lotto generateLotto() {
        List<Integer> numbers = numberGenerationStrategy.generateNumbers(
                NUMBER_COUNT.getValue(), MIN_NUMBER.getValue(), MAX_NUMBER.getValue());
        return new Lotto(numbers);
    }
}