package lotto;

public class WinningLotto {
    private final Lotto winLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        this.winLotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Rank match(Lotto lotto) {
        int matched = winLotto.countMatchingNumbers(lotto);
        boolean matchedBonus = lotto.hasBonusNumber(bonusNumber);
        return Rank.Of(matched, matchedBonus);
    }


}
