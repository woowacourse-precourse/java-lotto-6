package lotto.domain;

public class PrizeLotto {
    private final Lotto winLotto;
    private final int bonusNum;

    public PrizeLotto(Lotto lotto, int bonusNum) {
        this.winLotto = lotto;
        this.bonusNum = bonusNum;
    }

    public Rank match(Lotto purchasedLotto) {
        int count = (int) purchasedLotto.getNumbers().stream()
                .filter(i -> winLotto.getNumbers().contains(i))
                .count();

        boolean isBonusMatch = purchasedLotto.getNumbers().stream()
                .anyMatch(i -> i == bonusNum);

        return Rank.valueOf(count, isBonusMatch);
    }
}
