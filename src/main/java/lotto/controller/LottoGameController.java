package lotto.controller;

import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

public class LottoGameController {
    private final ConsoleInputView inputView;
    private final ConsoleOutputView outputView;

    public LottoGameController(ConsoleInputView inputView, ConsoleOutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
    }
}
