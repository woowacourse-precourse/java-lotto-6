package lotto.domain.strategy;

import java.util.List;
import lotto.domain.Lotto;

public class RandomLottoPublisher implements LottoPublisher {

    private final RandomGenerator<List<Integer>> randomNumbersGenerator;

    public RandomLottoPublisher(RandomGenerator<List<Integer>> randomNumbersGenerator) {
        this.randomNumbersGenerator = randomNumbersGenerator;
    }

    @Override
    public Lotto publish() {
        return new Lotto(randomNumbersGenerator.generate());
    }

}
