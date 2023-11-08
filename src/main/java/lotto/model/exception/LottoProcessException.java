package lotto.model.exception;

import static lotto.model.enums.MagicVariable.LOTTO_PRICE;
import static lotto.model.enums.ErrorMessage.PRICE_ERROR_MESSAGE;
import static lotto.model.enums.ErrorMessage.PRICE_TYPE_ERROR_MESSAGE;
import static lotto.model.enums.ErrorMessage.PRICE_NEGATIVE_ERROR_MESSAGE;

public class LottoProcessException extends IllegalArgumentException {
    private LottoProcessException(String message) {
        super(message);
    }

    public static void checkLottoPriceRangeException(int money) {
        if (money % LOTTO_PRICE.getNumber() != 0) {
            throw new LottoProcessException(PRICE_ERROR_MESSAGE.getErrorMessage());
        }
    }

    public static void checkLottoPriceTypeException(String userMoney) {
        if (!userMoney.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new LottoProcessException(PRICE_TYPE_ERROR_MESSAGE.getErrorMessage());
        }
    }

    public static void checkLottoPriceNegativeException(String userMoney) {
        if (userMoney.contains("-")) {
            throw new LottoProcessException(PRICE_NEGATIVE_ERROR_MESSAGE.getErrorMessage());
        }
    }
}
