package lotto;

public class WinningLotto {
    private Lotto winningNumbers;
    private int bonusNumber;

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public LottoRank makeRank(Lotto lotto) {
        int matchCount = lotto.checkMatchCount(winningNumbers);
        boolean matchBonus = lotto.contains(bonusNumber);
        return LottoRank.belongedToRank(matchCount, matchBonus);
    }
}
