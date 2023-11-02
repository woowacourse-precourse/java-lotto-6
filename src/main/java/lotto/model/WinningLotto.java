package lotto.model;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private Prize determinePrize(int matchCount, boolean bonusMatch) {
        for (Prize prize : Prize.values()){
            if (prize.getMatchCount() == matchCount && prize.isBonusMatch() == bonusMatch) {
                return prize;
            }
        }
        return null;
    }

    public Prize calculatePrize(Lotto userLotto) {
        int matchCount = userLotto.countMatchNumbers(winningLotto);
        boolean bonusMatch = userLotto.hasBonusNumber(bonusNumber);
        return determinePrize(matchCount, bonusMatch);
    }
 }
