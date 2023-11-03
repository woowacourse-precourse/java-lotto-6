package lotto.controller;

import lotto.controller.subcontroller.IssueLottoController;
import lotto.view.InputView;
import lotto.view.OutputView;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;
    private IssueLottoController issueLottoController;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        initializeControllers();
    }

    private void initializeControllers() {
        issueLottoController = new IssueLottoController(inputView, outputView);
    }

    public void start() {
        issueLottoController.process();
    }
}
