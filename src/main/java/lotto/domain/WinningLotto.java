package lotto.domain;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Prize match(Lotto userLotto) {
        int matchCount = lotto.matchCount(userLotto);
        boolean matchBonus = userLotto.contains(bonusNumber);
        return Prize.valueOf(matchCount, matchBonus);
    }
}
