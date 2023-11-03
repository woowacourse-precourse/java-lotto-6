package lotto.model;

public class LottoDraw {
    private Lotto winningLotto;
    private int bonusNumber;

    private LottoDraw() {
    }

    public LottoDraw(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }
}
