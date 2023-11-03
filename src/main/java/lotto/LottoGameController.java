package lotto;

import lotto.domain.PurchasePrice;
import lotto.view.InputView;

public class LottoGameController {
    private InputView inputView = new InputView();
    private PurchasePrice purchasePrice;

    public void startGame() {
        purchasePrice = new PurchasePrice(inputView.requestPurchasePrice());
    }
}
