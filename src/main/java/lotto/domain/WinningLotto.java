package lotto.domain;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Rank match(final Lotto lotto) {
        int matched = this.lotto.countMatchingNumbers(lotto);
        boolean matchedBonus = lotto.hasBonusNumber(bonusNumber);
        return Rank.Of(matched, matchedBonus);
    }


}
