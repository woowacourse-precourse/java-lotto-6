package lotto.domain;

import static lotto.ErrorMessage.LOTTO_PURCHASE_ERROR;

import java.util.List;
import java.util.stream.Stream;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;

    private final NumbersCreator numbersCreator;

    public LottoMachine(NumbersCreator numbersCreator) {
        this.numbersCreator = numbersCreator;
    }

    public Lottos purchaseLotto(Money purchaseMoney) {
        validate(purchaseMoney);
        int lottoQuantity = purchaseMoney.calculateQuantity(LOTTO_PRICE);
        return new Lottos(createLottos(lottoQuantity));
    }

    private static void validate(Money purchaseMoney) {
        if (!purchaseMoney.isUnitOf(LOTTO_PRICE)) {
            throw new IllegalArgumentException(String.format(LOTTO_PURCHASE_ERROR.getMessage(), LOTTO_PRICE));
        }
    }

    private List<Lotto> createLottos(int lottoQuantity) {
        return Stream.generate(() -> Lotto.createLotto(numbersCreator))
                .limit(lottoQuantity)
                .toList();
    }
}
