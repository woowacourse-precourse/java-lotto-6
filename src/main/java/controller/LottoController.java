package controller;

import view.InputView;
import view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private int numberOfSheets;

    public LottoController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() {
        requestLottoAmount();
        buyLottoCount();
    }

    private void requestLottoAmount() {
        inputView.printRequestAmount();
        Integer amount = inputView.InputAmount();
        numberOfSheets = outputView.printNumberOfSheets(amount);
    }

    private void buyLottoCount() {
        outputView.printLottoSheet(numberOfSheets);
    }
}
