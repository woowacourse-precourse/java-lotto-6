package lotto.domain.lotto.userLotto;

import static lotto.domain.lotto.LottoCondition.PRICE;

public class LottoAmount {

    private final int lottoAmount;

    public LottoAmount(int purchasePrice) {
        lottoAmount = purchasePrice / PRICE.getValue();
    }

    public int getLottoAmount() {
        return lottoAmount;
    }
}
