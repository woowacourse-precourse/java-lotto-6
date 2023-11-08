package lotto;

public class WinningLotto {
    private Lotto winner;
    private int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        winner = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Rank getRank(Lotto lotto) {
        int sameCount = lotto.countSameNumber(winner);
        boolean containsBonusNumber = lotto.containsBonusNumber(bonusNumber);

        return Rank.getRank(sameCount, containsBonusNumber);
    }
}
