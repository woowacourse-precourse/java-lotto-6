package lotto.domain;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonus;

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonus() {
        return bonus;
    }

    public WinningLotto(Lotto lotto, int bonus) {
        this.winningLotto = lotto;
        this.bonus = bonus;
        validateBonusNumber();
    }

    private void validateBonusNumber() {
        validateNumberRange();
        validateNoDuplicates();
    }

    private void validateNoDuplicates() {
        if (winningLotto.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberRange() {
        if (!isInRange(bonus)) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean isInRange(int num) {
        return num >= 1 && num <= 45;
    }

}
