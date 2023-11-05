package lotto;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank getRank(Lotto lotto) {
        long matchCount = winningNumbers.getMatchCount(lotto);
        boolean isMatchBonusNumber = lotto.isContains(bonusNumber);

        return Rank.getRank((int) matchCount, isMatchBonusNumber);
    }
}
