package lotto.model.exception;

import static lotto.model.MagicVariable.LOTTO_PRICE;

public class LottoProcessException extends IllegalArgumentException {
    private LottoProcessException(String message) {
        super(message);
    }

    public static void checkLottoPriceException(int money) {
        if (money % LOTTO_PRICE.getNumber() != 0 || money < LOTTO_PRICE.getNumber()) {
            String PRICE_ERROR_MESSAGE = "[ERROR] 로또 구입 금액은 " + LOTTO_PRICE.getNumber() + "원 단위의 양수여야 합니다.";
            throw new LottoProcessException(PRICE_ERROR_MESSAGE);
        }
    }

    public static void checkLottoPriceTypeException(String uesrMoney) {
        if (!uesrMoney.matches("^[0-9]+$")) {
            String LOTTO_PRICE_TYPE_ERROR_MESSAGE = "[ERROR] 구입 금액은 양수여야 합니다.";
            throw new LottoProcessException(LOTTO_PRICE_TYPE_ERROR_MESSAGE);
        }
    }
}
