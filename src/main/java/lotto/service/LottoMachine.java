package lotto.service;

import lotto.view.InputView;

public class LottoMachine {
    private final InputView inputView;
    private int lottoBudget;

    public LottoMachine() {
        this.inputView = new InputView();
    }

    public void start() {
        lottoBudget = inputView.getLottoBudget();
    }
}
