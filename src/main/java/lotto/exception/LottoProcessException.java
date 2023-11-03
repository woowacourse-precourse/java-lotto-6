package lotto.exception;

import static lotto.model.MagicVariable.LOTTO_PRICE;
import static lotto.model.MagicVariable.NON_PURCHASE_PRICE;

public class LottoProcessException extends IllegalArgumentException {
    public LottoProcessException(String message) {
        super(message);
    }

    public static void checkPurchaseMoney(int money) {
        if (money % LOTTO_PRICE.getNumber() != 0 || money <= NON_PURCHASE_PRICE.getNumber()) {
            String PRICE_ERROR_MESSAGE = "[ERROR] 로또 구입 금액은 " + LOTTO_PRICE.getNumber() + "원 단위의 양수여야 합니다.";
            throw new LottoProcessException(PRICE_ERROR_MESSAGE);
        }
    }
}
