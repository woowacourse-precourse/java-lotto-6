package lotto.domain;

import java.util.List;

public class LotteriesGenerator {

    private final NumbersGeneratorStrategy numbersGeneratorStrategy;

    public LotteriesGenerator(final NumbersGeneratorStrategy numbersGeneratorStrategy) {
        this.numbersGeneratorStrategy = numbersGeneratorStrategy;
    }

    public Lotteries createByPurchaseCount(final int purchaseCount) {
        if (purchaseCount <= 0) {
            throw new IllegalArgumentException();
        }
        return Lotteries.from(List.of());
    }
}
