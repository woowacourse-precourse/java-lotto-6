package controller;

import view.InputView;
import view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(final InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }
}
