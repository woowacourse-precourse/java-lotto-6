package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;

public class LottoMarket {
    private final NumbersGenerator numbersGenerator;

    public LottoMarket(NumbersGenerator numbersGenerator) {
        this.numbersGenerator = numbersGenerator;
    }

    public List<Lotto> sellLotto(Money money) {
        int purchasedCount = money.convertMoneyToCount();
        return IntStream.range(0, purchasedCount)
                .mapToObj(count -> new Lotto(numbersGenerator.generate()))
                .toList();
    }

}
