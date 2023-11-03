package lotto.controller;

import lotto.view.InputValue;
import lotto.view.OutputValue;

public class LottoController {

    public LottoController() {
        lottoInit();
        lottoProcess();
        lottoEnd();
    }

    private void lottoInit() {

        OutputValue.purchaseMessage();
        int purchasePrice = InputValue.getPurchasePrice();

    }

    private void lottoProcess() {

    }

    private void lottoEnd() {

    }
}
