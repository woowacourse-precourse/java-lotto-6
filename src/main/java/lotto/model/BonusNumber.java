package lotto.model;

public class BonusNumber {
    private int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int input) {
        validateInRange(input);
    }

    private void validateInRange(int input) {
        if (input < 1 || input > 45) {
            throw new IllegalArgumentException("[ERROR] 1 ~ 45 사이의 숫자를 입력해야 합니다.");
        }
    }
}
