package lotto.model;

public class BonusNumber {
    private static final int BONUS_MIN_NUMBER = 1;
    private static final int BONUS_MAX_NUMBER = 45;
    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    private void validate(int bonusNumber) {
        if (!isInRange(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호의 범위가 맞지 않습니다.");
        }
    }

    private boolean isInRange(int number) {
        return number >= BONUS_MIN_NUMBER && number <= BONUS_MAX_NUMBER;
    }
}