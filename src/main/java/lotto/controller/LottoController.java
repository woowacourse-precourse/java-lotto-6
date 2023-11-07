package lotto.controller;

import lotto.model.LottoPurchasingAmount;

public class LottoController {
    private final InputController inputController;

    public LottoController() {
        this.inputController = new InputController();
    }

    public void initLotto() {
        LottoPurchasingAmount lottoPurchasingAmount =
                inputController.getLottoPurchasingAmountFromUser();
    }
}
