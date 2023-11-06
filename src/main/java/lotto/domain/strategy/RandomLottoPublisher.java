package lotto.domain.strategy;

import lotto.domain.Lotto;

public class RandomLottoPublisher implements LottoPublisher {
    private final RandomNumbersGenerator randomNumbersGenerator;

    public RandomLottoPublisher(RandomNumbersGenerator randomNumbersGenerator) {
        this.randomNumbersGenerator = randomNumbersGenerator;
    }

    @Override
    public Lotto publish() {
        return new Lotto(randomNumbersGenerator.generate());
    }
}
