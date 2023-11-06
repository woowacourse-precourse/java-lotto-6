package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void start(){
        OutputView.printRequestPurchaseAmount();
        InputView.inputPurchaseAmount();
    }
}
