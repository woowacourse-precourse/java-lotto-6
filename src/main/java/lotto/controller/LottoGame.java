package lotto.controller;

import lotto.view.InputView;

public class LottoGame {

    private final InputView inputView;

    public LottoGame() {
        this.inputView = new InputView();
    }

    public void run(){
        inputView.inputPrice();
    }
}
