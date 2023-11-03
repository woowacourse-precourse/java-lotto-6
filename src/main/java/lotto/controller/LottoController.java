package lotto.controller;

import lotto.view.InputValue;
import lotto.view.OutputValue;

public class LottoController {

    private int lottoCount;

    public LottoController() {
        lottoInit();
        lottoProcess();
        lottoEnd();
    }

    private void lottoInit() {

        OutputValue.purchaseMessage();
        lottoCount = InputValue.getPurchasePrice() / 1000;

        OutputValue.lottoCountMessage(lottoCount);

    }

    private void lottoProcess() {

    }

    private void lottoEnd() {

    }
}
