package lotto.domain;

import lotto.view.InputView;

public class WinningLotto {
    private Lotto winningLotto;
    public WinningLotto() {
        inputWinningNumbers();
    }



    private void inputWinningNumbers() {
        System.out.println();
        winningLotto = new Lotto(InputView.inputLotto());
    }

}
