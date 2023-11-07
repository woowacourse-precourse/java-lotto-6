package lotto.domain;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonus;

    public WinningLotto(Lotto lotto, int bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public boolean isMatch(Winning winning, Lotto userLotto) {
        int matchCount = this.lotto.matchCount(userLotto);

        if(winning.isIncludeBonus()) {
            return winning.getMatchCount() == matchCount && userLotto.includes(bonus);
        }

        return winning.getMatchCount() == matchCount;
    }


}
