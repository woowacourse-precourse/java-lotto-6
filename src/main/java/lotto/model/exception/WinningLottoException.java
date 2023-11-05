package lotto.model.exception;

import static lotto.model.MagicVariable.NUMBERS_MAX_RANGE;
import static lotto.model.MagicVariable.NUMBERS_MIN_RANGE;

import java.util.List;

public class WinningLottoException extends IllegalArgumentException{
    public WinningLottoException(String message) {
        super(message);
    }

    public static void checkBonusNumberTypeException(String userBonusNumber) {
        if (!userBonusNumber.matches("\\d+")) {
            String BONUS_NUMBER_TYPE_ERROR_MESSAGE = "[ERROR] 보너스 번호는 숫자여야 합니다.";
            throw new WinningLottoException(BONUS_NUMBER_TYPE_ERROR_MESSAGE);
        }
    }

    public static void checkBonusNumberNegativeException(int userBonusNumber) {
        if (userBonusNumber <= NUMBERS_MIN_RANGE.getNumber()) {
            String BONUS_NUMBER_NEGATIVE_ERROR_MESSAGE = "[ERROR] 보너스 번호는 양수여야 합니다.";
            throw new WinningLottoException(BONUS_NUMBER_NEGATIVE_ERROR_MESSAGE);
        }
    }

    public static void checkBonusNumberRangeException(int bonusNumber) {
        if (bonusNumber < NUMBERS_MIN_RANGE.getNumber() || bonusNumber > NUMBERS_MAX_RANGE.getNumber()) {
            String BONUS_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 보너스 번호는 " + NUMBERS_MIN_RANGE.getNumber() + "에서 " + NUMBERS_MAX_RANGE.getNumber() + " 범위 내의 숫자여야 합니다.";
            throw new WinningLottoException(BONUS_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    public static void checkBonusNumberDuplicationException(List<Integer> winningLotto, int bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            String BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE = "[ERROR] 보너스 번호는 중복되지 않는 수만 가능합니다.";
            throw new WinningLottoException(BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
    }
}
