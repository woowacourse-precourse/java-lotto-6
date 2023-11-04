package lotto.validator;

public class BonusNumberValidator {
    public void validate(String bonusNumber) {
        checkBlank(bonusNumber);
        checkDigit(bonusNumber);
        checkValidRangeNumber(bonusNumber);
    }

    private void checkBlank(String bonusNumber) {
        if (isBlank(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 입력하세요. 값이 null 또는 빈 값일 수 없습니다.");
        }
    }

    private boolean isBlank(String bonusNumber) {
        return bonusNumber == null || bonusNumber.isBlank();
    }

    private void checkDigit(String bonusNumber) {
        if(isNotDigit(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자를 입력해야 합니다.");
        }
    }

    private boolean isNotDigit(String bonusNumber) {
        return !bonusNumber.chars()
                .allMatch(Character::isDigit);
    }

    private void checkValidRangeNumber(String bonusNumber) {
        if(isInvalidRangeNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45사이의 숫자를 입력해야 합니다");
        }
    }

    private boolean isInvalidRangeNumber(String bonusNumber) {
        int number = Integer.parseInt(bonusNumber);
        return (number <= 0 || 45 < number);
    }
}
