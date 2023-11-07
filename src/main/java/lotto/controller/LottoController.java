package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.PurchasePrice;
import lotto.model.UniqueRandomNumbers;
import lotto.view.InputView;

public class LottoController {
    private static final int ONE_LOTTO_PRICE = 1000;
    private PurchasePrice purchasePrice;
    private Lottos lottos;

    private void setPurchasePrice() {
        purchasePrice = new PurchasePrice(InputView.inputPrice());
    }
    private Lotto makeLotto() {
        return new Lotto(new UniqueRandomNumbers().getNumbers());
    }
    private void makeSeveralLottos() {
        lottos = new Lottos();
        int countPurchaseLottos = purchasePrice.getPrice() / ONE_LOTTO_PRICE;
        for (int nums = 0; nums < countPurchaseLottos; nums++) {
            lottos.add(makeLotto());
        }
    }
}
