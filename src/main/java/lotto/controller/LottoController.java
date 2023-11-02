package lotto.controller;

import lotto.view.InputView;

import java.util.ArrayList;

public class LottoController {
    private final InputView inputView;

    public LottoController() {
        this.inputView = new InputView();
    }

    public void run() {
        Integer money = inputView.inputMoney();
        ArrayList<Integer> winningNumber = inputView.winningNumber();
        Integer bonusNumber = inputView.bonusNumber(winningNumber);
    }
}
