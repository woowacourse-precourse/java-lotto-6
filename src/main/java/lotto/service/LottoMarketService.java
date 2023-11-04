package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.NumbersGenerator;

public class LottoMarketService {
    private static final int LOTTO_PRICE = 1000;
    private final NumbersGenerator numbersGenerator;
    private final int purchasedCount;

    public LottoMarketService(Money money, NumbersGenerator numbersGenerator) {
        this.purchasedCount = convertMoneyIntoCount(money);
        this.numbersGenerator = numbersGenerator;
    }

    public Lottos makeLottos() {
        Lottos lottos = new Lottos();
        for (int i = 0; i < purchasedCount; i++) {
            lottos.add(new Lotto(numbersGenerator.generate()));
        }
        return lottos;
    }

    public int getPurchasedCount() {
        return purchasedCount;
    }

    private int convertMoneyIntoCount(Money money) {
        return money.getValue() / LOTTO_PRICE;
    }
}
