package lotto.domain.userLotto;

import static lotto.domain.LottoCondition.PURCHASE_PRICE;

public class LottoAmount {

    private final int lottoAmount;

    public LottoAmount(int purchasePrice) {
        this.lottoAmount = purchasePrice / PURCHASE_PRICE.getValue();
    }

    public int getLottoAmount() {
        return lottoAmount;
    }
}
