package lotto.domain;

import lotto.controller.InputController;

public class WinningLotto {
    private Lotto winningLotto;

    public WinningLotto() {
        inputWinningNumbers();
    }

    public int grade(Lotto lotto) {
        return winningLotto.compareWithAnotherLotto(lotto);
    }

    public boolean contains(int number) {
        return winningLotto.contains(number);
    }

    private void inputWinningNumbers() {
        System.out.println();
        winningLotto = new Lotto(InputController.inputWinningNumbersUntilSuccess());
    }
}
