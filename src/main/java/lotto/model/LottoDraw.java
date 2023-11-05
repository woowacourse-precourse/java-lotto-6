package lotto.model;

public class LottoDraw {
    private Lotto winningNumbers;
    private BonusNumber bonusNumber;

    private LottoDraw() {
    }

    private LottoDraw(Lotto winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static LottoDraw of(Lotto winningNumbers, BonusNumber bonusNumber) {
        return new LottoDraw(winningNumbers, bonusNumber);
    }
}
