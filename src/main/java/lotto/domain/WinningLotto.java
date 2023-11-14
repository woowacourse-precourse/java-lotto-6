package lotto.domain;


// 당첨 번호와 보너스 번호를 나타내는 클래스
public class WinningLotto {
    private final Lotto winningNumbers;

    private final int bonusNumber;

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank match(Lotto other) {
        int matchCount = winningNumbers.countMatch(other);
        boolean matchBonus = other.contains(bonusNumber);
        return Rank.getRank(matchCount, matchBonus);
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
