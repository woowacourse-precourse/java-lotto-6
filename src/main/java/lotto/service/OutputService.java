package lotto.service;

import lotto.view.OutputView;

public class OutputService {
    private final OutputView outputView;

    public OutputService(OutputView outputView) {
        this.outputView = outputView;
    }

    public void purchaseAmount() {
        outputView.purchaseAmount();
    }

    public void handleException(IllegalArgumentException exception) {
        outputView.printExceptionMessage(exception.getMessage());
    }
}
