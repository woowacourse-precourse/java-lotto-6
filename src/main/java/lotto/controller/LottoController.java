package lotto.controller;

import lotto.view.ConsoleInputView;

public class LottoController {

    private final ConsoleInputView consoleInputView;

    public LottoController(ConsoleInputView consoleInputView) {
        this.consoleInputView = consoleInputView;
    }

    public void lottoGamePlay() {
        consoleInputView.inputBuyLottoAmount();
    }

}
