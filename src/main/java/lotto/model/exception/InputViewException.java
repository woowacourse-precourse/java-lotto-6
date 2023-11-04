package lotto.model.exception;

import static lotto.model.MagicVariable.NONE_PURCHASE_PRICE;
import static lotto.model.MagicVariable.LOTTO_PRICE;
import static lotto.model.MagicVariable.NUMBERS_MIN_RANGE;
import static lotto.model.MagicVariable.NUMBERS_MAX_RANGE;

import java.util.List;


public class InputViewException extends IllegalArgumentException {
    private InputViewException(String message) {
        super(message);
    }

    public static void checkLottoPriceException(String userAmount) {
        int amount = Integer.parseInt(userAmount);
        if (amount <= NONE_PURCHASE_PRICE.getNumber() || amount % LOTTO_PRICE.getNumber() != 0) {
            String LOTTO_PRICE_ERROR_MESSAGE = "[ERROR] 구입 금액은 "+ LOTTO_PRICE.getNumber() + "원 단위의 양수여야 합니다.";
            throw new InputViewException(LOTTO_PRICE_ERROR_MESSAGE);
        }
    }

    public static void checkLottoPriceTypeException(String userAmount) {
        if (!userAmount.matches("^[0-9]+$")) {
            String LOTTO_PRICE_TYPE_ERROR_MESSAGE = "[ERROR] 구입 금액은 양수여야 합니다.";
            throw new InputViewException(LOTTO_PRICE_TYPE_ERROR_MESSAGE);
        }
    }

    public static void checkBonusTypeException(String userBonusNumber) {
        if (!userBonusNumber.matches("^[0-9]+$")) {
            String BONUS_NUMBER_TYPE_ERROR_MESSAGE = "[ERROR] 보너스 번호는 양수여야 합니다.";
            throw new InputViewException(BONUS_NUMBER_TYPE_ERROR_MESSAGE);
        }
    }

    public static void checkBonusNumberRangeException(String userBonusNumber) {
        int bonusNumber = Integer.parseInt(userBonusNumber);

        if (bonusNumber < NUMBERS_MIN_RANGE.getNumber() || bonusNumber > NUMBERS_MAX_RANGE.getNumber()) {
            String BONUS_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 보너스 번호는 " + NUMBERS_MIN_RANGE.getNumber() + "에서 " + NUMBERS_MAX_RANGE.getNumber() + " 범위 내의 숫자여야 합니다.";
            throw new InputViewException(BONUS_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    public static void checkBonusNumberDuplicationException(List<Integer> winningLotto, int bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            String BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE = "[ERROR] 보너스 번호는 중복되지 않는 수만 가능합니다.";
            throw new InputViewException(BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
    }
}
