package controller;

import domain.AmountInput;
import view.InputView;

public class LottoController {

    private final InputView inputView;
    private AmountInput amount;

    public LottoController() {
        inputView = new InputView();
    }

    public void start() {
        RequestLottoAmount();
    }

    private void RequestLottoAmount() {
        inputView.printRequestAmount();
        amount = new AmountInput();
    }
}
