package lotto;

import static lotto.Application.winningNumbers;

public class bonusNumberException {
    public static void isBonusNumeric(String inputBonusNumber) {
        if (inputBonusNumber == null || inputBonusNumber.isEmpty())
            throw new IllegalArgumentException("빈 번호는 입력할 수 없습니다.");
        for (char c : inputBonusNumber.toCharArray()) {
            if(!Character.isDigit(c)) {
                throw new IllegalArgumentException("보너스 번호는 숫자여야 합니다");
            }
        }
    }
    public static void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("보너스 번호는 1에서 45사이의 숫자입니다.");
        }
    }
    public static void validateBonusNotDuplicate(int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
