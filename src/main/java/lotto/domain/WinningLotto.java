package lotto.domain;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonus;

    public WinningLotto(Lotto lotto, int bonus) {
        this.winningLotto = lotto;
        this.bonus = bonus;
        validateBonusNumber();
    }

    private void validateBonusNumber() {
        validateNumberRange();
        validateNoDuplicates();
        //validateNumericValues();
    }

    private void validateNoDuplicates() {
        if (winningLotto.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException();
        }
    }
    private void validateNumericValues() {
        // 여기에서 한번에 예외 체크할지 Input 클래스에서 나눠서 할지
    }

    private void validateNumberRange() {
        if(!isInRange(bonus)) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean isInRange(int num) {
        return num >= 1 && num <= 45;
    }

}
