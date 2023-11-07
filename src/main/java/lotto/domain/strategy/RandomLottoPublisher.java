package lotto.domain.strategy;

import lotto.domain.Lotto;

public class RandomLottoPublisher implements LottoPublisher {
    private final RandomGenerator<Integer> randomNumbersGenerator;

    public RandomLottoPublisher(RandomGenerator<Integer> randomNumbersGenerator) {
        this.randomNumbersGenerator = randomNumbersGenerator;
    }

    @Override
    public Lotto publish() {
        return new Lotto(randomNumbersGenerator.generate());
    }
}
