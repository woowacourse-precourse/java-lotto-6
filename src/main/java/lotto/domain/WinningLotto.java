package lotto.domain;

public class WinningLotto {
    private Lotto lotto;

    private int bonusNum;

    public WinningLotto(Lotto lotto, int bonusNum) {
        validateDuplicateWinningLotto(lotto, bonusNum);
        this.lotto = lotto;
        this.bonusNum = bonusNum;
    }

    private void validateDuplicateWinningLotto(Lotto lotto, int bonusNum) {
        if (lotto.getNumbers().contains(bonusNum)) {
            throw new IllegalArgumentException();
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
