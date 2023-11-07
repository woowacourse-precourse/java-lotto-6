package lotto.model;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(String bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private void validateBonusNumber(String bonus) {
        isInteger(bonus);
        isCorrectRange(bonus);
    }

    private void isInteger(String bonus) {
        if (!bonus.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }

    private void isCorrectRange(String bonus) {
        int bonusNumber = Integer.parseInt(bonus);

        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
