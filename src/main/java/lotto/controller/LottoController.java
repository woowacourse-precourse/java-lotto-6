package lotto.controller;

import lotto.validator.LottoValidator;
import lotto.view.InputView;

public class LottoController {

    public static final int LOTTO_PRICE = 1_000;

    public void start() {
        int purchaseAmount = InputView.enterLottoPurchaseAmount();
        LottoValidator.validatePurchaseAmount(purchaseAmount);
    }
}
