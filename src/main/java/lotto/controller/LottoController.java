package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.LottoSystem;
import lotto.dto.PurchasedLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoSystem lottoSystem = new LottoSystem(new Buyer());

    public void start() {
        buyLotto();
    }

    private void buyLotto() {
        do {
            try {
                int purchaseAmount = InputView.enterLottoPurchaseAmount();
                lottoSystem.buyLotto(purchaseAmount);
                break;
            } catch (IllegalArgumentException exception) {
                exception.printStackTrace(System.out);
            }
        } while (true);

        PurchasedLotto purchasedLotto = lottoSystem.getPurchasedLotto();
        OutputView.printPurchasedLotto(purchasedLotto);
    }
}
