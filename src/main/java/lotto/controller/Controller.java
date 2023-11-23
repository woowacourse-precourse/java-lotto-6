package lotto.controller;

import lotto.service.Service;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class Controller {

    private final Service service;
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(final Service service,
                      final InputView inputView,
                      final OutputView outputView) {
        this.service = service;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        initAmount();
    }

    private void initAmount() {
        inputView.readAmount();
    }

}
