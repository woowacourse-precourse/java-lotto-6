package lotto.domain;

import lotto.view.InputView;

public class WinningLotto {

    private final Lotto winningLotto;

    public WinningLotto() {
        winningLotto = makeWinningLotto();
    }

    public WinningLotto(Lotto lotto) {
        winningLotto = lotto;
    }

    public boolean contains(int number) {
        return winningLotto.contains(number);
    }

    public int grade(Lotto lotto) {
        return winningLotto.compareWithAnotherLotto(lotto);
    }

    private Lotto makeWinningLotto() {
        return new Lotto(InputView.readWinnerNumber());
    }


}
