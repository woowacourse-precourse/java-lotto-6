package lotto.domain;

import lotto.io.InputHandler;

public class WinningLotto {

    private final Lotto winningLotto;

    public WinningLotto() {
        winningLotto = makeWinningLotto();
    }

    public boolean contains(int number) {
        return winningLotto.contains(number);
    }

    public int grade(Lotto lotto) {
        return winningLotto.compareWithAnotherLotto(lotto);
    }

    private Lotto makeWinningLotto() {
        return new Lotto(InputHandler.readWinnerNumber());
    }


}
