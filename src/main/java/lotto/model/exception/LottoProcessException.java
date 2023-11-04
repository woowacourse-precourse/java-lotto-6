package lotto.model.exception;

import static lotto.model.MagicVariable.LOTTO_PRICE;
import static lotto.model.MagicVariable.NONE_PURCHASE_PRICE;

public class LottoProcessException extends IllegalArgumentException {
    private LottoProcessException(String message) {
        super(message);
    }

    public static void checkPurchaseMoney(int money) {
        if (money % LOTTO_PRICE.getNumber() != 0 || money <= NONE_PURCHASE_PRICE.getNumber()) {
            String PRICE_ERROR_MESSAGE = "[ERROR] 로또 구입 금액은 " + LOTTO_PRICE.getNumber() + "원 단위의 양수여야 합니다.";
            throw new LottoProcessException(PRICE_ERROR_MESSAGE);
        }
    }
}
