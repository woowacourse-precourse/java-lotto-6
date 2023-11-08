package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.Error.Domain.WRONG_PRICE;

public final class LottoMachine {
    static final long PRICE_PER_LOTTO = 1000L;
    private final LottoCreateModel lottoCreateModel;

    public LottoMachine(LottoCreateModel lottoCreateModel) {
        this.lottoCreateModel = lottoCreateModel;
    }

    public BuyLotto generateForPrice(long price) {
        validate(price);

        int amount = (int) (price / PRICE_PER_LOTTO);
        return generateLotto(amount);
    }

    private void validate(Long price) {
        if (price % PRICE_PER_LOTTO != 0) {
            throw new IllegalArgumentException(
                    WRONG_PRICE.getText().formatted(PRICE_PER_LOTTO));
        }
    }

    private BuyLotto generateLotto(int amount) {
        List<Lotto> lotto = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            Lotto generate = lottoCreateModel.generate();
            lotto.add(generate);
        }
        return new BuyLotto(lotto);
    }
}
