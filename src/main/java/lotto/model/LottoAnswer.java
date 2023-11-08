package lotto.model;

public class LottoAnswer {
    private final Lotto winningNumbers;
    private final BonusNumber bounsNumber;

    public LottoAnswer(Lotto winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bounsNumber = bonusNumber;
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public BonusNumber getBounsNumber() {
        return bounsNumber;
    }
}
