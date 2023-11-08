package lotto.domain;

public class WinningLotto {
    private final Lotto lotto;
    private final Integer bonusNumber;

    public WinningLotto(Lotto lotto, Integer bonusNumber) {
        assertValidWinningLotto(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void assertValidWinningLotto(Lotto lotto, Integer bonusNumber) {
        if (bonusNumber > 45 || bonusNumber < 1) {
            throw new IllegalArgumentException();
        }

        if (lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
