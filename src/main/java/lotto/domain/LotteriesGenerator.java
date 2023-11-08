package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;

public class LotteriesGenerator {

    private final NumbersGeneratorStrategy numbersGeneratorStrategy;

    public LotteriesGenerator(final NumbersGeneratorStrategy numbersGeneratorStrategy) {
        this.numbersGeneratorStrategy = numbersGeneratorStrategy;
    }

    public Lotteries createByPurchaseCount(final Money money) {
        int purchaseCount = money.calculateLottoPurchaseCount();
        List<Lotto> lottos = IntStream.range(0, purchaseCount)
                .mapToObj(index -> new Lotto(numbersGeneratorStrategy.generate()))
                .toList();
        return Lotteries.from(lottos);
    }
}
