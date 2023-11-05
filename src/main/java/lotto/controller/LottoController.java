package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.LottoIntermediary;
import lotto.view.InputView;

public class LottoController {

    private final LottoIntermediary intermediary = new LottoIntermediary(new Buyer());

    public void start() {
        buyLotto();
    }

    private void buyLotto() {
        do {
            try {
                int purchaseAmount = InputView.enterLottoPurchaseAmount();
                intermediary.buyLotto(purchaseAmount);
                break;
            } catch (IllegalArgumentException exception) {
                exception.printStackTrace(System.out);
            }
        } while (true);
    }
}
