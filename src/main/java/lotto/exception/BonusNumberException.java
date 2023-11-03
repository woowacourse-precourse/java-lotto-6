package lotto.exception;

import java.util.List;

public class BonusNumberException extends IllegalArgumentException {

    public BonusNumberException(String message) {
        super(message);
    }

    public static void ensureValidFormat(String inputBonusNumber) {
        if (!inputBonusNumber.matches("^([1-9]|[1-3]\\d|4[0-5])$")) {
            throw new BonusNumberException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }

    public static void ensureNotDuplicatedWithWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new BonusNumberException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public static void ensureWithinValidRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new BonusNumberException("[ERROR] 보너스 번호는 1~45 사이의 숫자만 가능합니다.");
        }
    }
}