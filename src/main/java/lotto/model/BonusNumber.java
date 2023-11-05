package lotto.model;

public class BonusNumber {
    private int bonusNumber;

    public BonusNumber(int inputBonusNumber) {
        validateBonusNumber(inputBonusNumber);
        this.bonusNumber = inputBonusNumber;
    }

    public void validateBonusNumber(int inputBonusNumber) {
        validateBonusNumberRange(inputBonusNumber);
    }

    private void validateBonusNumberRange(int inputBonusNumber) {
        if (inputBonusNumber < 1 || inputBonusNumber > 45) {
            throw new IllegalArgumentException("보너스 숫자는 1과 45 사이의 숫자를 입력해야 합니다.");
        }
    }
}
