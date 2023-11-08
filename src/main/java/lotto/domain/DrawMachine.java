package lotto.domain;

import lotto.View.InputView;

public class DrawMachine {
    private Lotto winningNumber;
    private int bonusNumber;
    private InputView inputView = new InputView();

    public void makeWinningNumber() {
//        winningNumber = new Lotto(inputView.getWinningNumber());
    }

    public void makeBonusNumber() {
        bonusNumber = inputView.getBonusNumber();
    }
}
