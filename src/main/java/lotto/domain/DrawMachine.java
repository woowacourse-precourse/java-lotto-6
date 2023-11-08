package lotto.domain;

import lotto.View.InputView;

public class DrawMachine {
    private Lotto winningNumbers;
    private int bonusNumber;
    private InputView inputView = new InputView();

    public void makeWinningNumbers() {
        winningNumbers = new Lotto(inputView.getWinningNumbers());
    }

    public void makeBonusNumber() {
        bonusNumber = inputView.getBonusNumber();
    }
}
