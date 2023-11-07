package lotto.domain.generator;

import static lotto.domain.LottoConfig.*;

import java.util.List;
import lotto.domain.model.Lotto;
import lotto.domain.generator.strategy.NumberGenerationStrategy;

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