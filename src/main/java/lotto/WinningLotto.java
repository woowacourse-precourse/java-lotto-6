package lotto;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto winningNumbers, LottoNumber bonusNumber) {
        validate(winningNumbers, bonusNumber);

        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.isContains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public Rank getRank(Lotto lotto) {
        long matchCount = winningNumbers.getMatchCount(lotto);
        boolean isMatchBonusNumber = lotto.isContains(bonusNumber);
        return Rank.getRank((int) matchCount, isMatchBonusNumber);
    }
}
