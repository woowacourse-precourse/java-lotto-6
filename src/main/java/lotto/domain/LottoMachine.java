package lotto.domain;

import static lotto.ErrorMessage.LOTTO_PURCHASE_ERROR;

import lotto.domain.creator.NumbersCreator;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;

    private final NumbersCreator numbersCreator;

    public LottoMachine(NumbersCreator numbersCreator) {
        this.numbersCreator = numbersCreator;
    }

    public Lottos purchaseLotto(Money purchaseMoney) {
        validate(purchaseMoney);
        int lottoQuantity = purchaseMoney.calculateQuantity(LOTTO_PRICE);
        return new Lottos();
    }

    private static void validate(Money purchaseMoney) {
        if (!purchaseMoney.isUnitOf(LOTTO_PRICE)) {
            throw new IllegalArgumentException(String.format(LOTTO_PURCHASE_ERROR.getMessage(), LOTTO_PRICE));
        }
    }

    private Lotto createLotto() {
        return Lotto.createLotto(numbersCreator);
    }
}
