package lotto.model;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank compareLotto(Lotto lotto) {
        int correctCount = winningNumbers.countCorrectNumbers(lotto);
        boolean containBonusNumber = lotto.contains(bonusNumber.bonusNumber());

        return Rank.valueOf(correctCount, containBonusNumber);
    }
}
