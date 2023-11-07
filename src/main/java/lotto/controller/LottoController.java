package lotto.controller;

import lotto.model.Lotto;
import lotto.model.PurchasePrice;
import lotto.model.UniqueRandomNumbers;
import lotto.view.InputView;

public class LottoController {
    private static final int ONE_LOTTO_PRICE = 1000;
    PurchasePrice purchasePrice;

    private void setPurchasePrice() {
        purchasePrice = new PurchasePrice(InputView.inputPrice());
    }
    private Lotto makeLotto() {
        return new Lotto(new UniqueRandomNumbers().getNumbers());
    }

}
