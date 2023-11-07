package lotto;

public class WinningLotto {

    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        validateBonusNumber(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Lotto lotto, int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45 || lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("Invalid bonus number.");
        }
    }

    public LottoRank checkRank(Lotto userLotto) {
        int matchCount = userLotto.matchCount(this.lotto);
        boolean matchBonus = userLotto.getNumbers().contains(bonusNumber);
        return LottoRank.valueOf(matchCount, matchBonus);
    }

}
