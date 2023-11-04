package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.Error.Domain.WRONG_PRICE;

public final class LottoMachine {
    static final int PRICE_PER_LOTTO = 1000;
    private final LottoCreateModel lottoCreateModel;

    public LottoMachine(LottoCreateModel lottoCreateModel) {
        this.lottoCreateModel = lottoCreateModel;
    }

    public PurchasedLotto generateForPrice(int price) {
        validate(price);

        int amount = price / PRICE_PER_LOTTO;
        return generateLotto(amount);
    }

    private PurchasedLotto generateLotto(int amount) {
        List<Lotto> lotto = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            Lotto generate = lottoCreateModel.generate();
            lotto.add(generate);
        }
        return new PurchasedLotto(lotto);
    }

    private void validate(int price) {
        if (price % PRICE_PER_LOTTO != 0) {
            throw new IllegalArgumentException(
                    WRONG_PRICE.getText().formatted(PRICE_PER_LOTTO));
        }
    }
}
