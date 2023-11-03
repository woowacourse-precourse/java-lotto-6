package lotto.exception;

import static lotto.model.MagicVariable.NONE_PURCHASE_PRICE;
import static lotto.model.MagicVariable.LOTTO_PRICE;


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
}
