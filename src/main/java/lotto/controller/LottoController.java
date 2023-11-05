package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.LottoIntermediary;
import lotto.dto.PurchasedLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

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

        PurchasedLotto purchasedLotto = intermediary.getPurchasedLotto();
        OutputView.printPurchasedLotto(purchasedLotto);
    }
}
