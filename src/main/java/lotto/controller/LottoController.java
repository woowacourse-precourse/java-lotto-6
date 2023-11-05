package lotto.controller;

import lotto.domain.LottoIntermediary;
import lotto.validator.LottoValidator;
import lotto.view.InputView;

public class LottoController {

    private final LottoIntermediary intermediary = new LottoIntermediary();

    public void start() {
        int purchaseAmount = inputLottoPurchaseAmount();
        intermediary.buyLottos(purchaseAmount);
    }

    private int inputLottoPurchaseAmount() {
        do {
            try {
                int purchaseAmount = InputView.enterLottoPurchaseAmount();
                LottoValidator.validatePurchaseAmount(purchaseAmount);
                return purchaseAmount;
            } catch (IllegalArgumentException exception) {
                exception.printStackTrace(System.out);
            }
        } while (true);
    }
}
