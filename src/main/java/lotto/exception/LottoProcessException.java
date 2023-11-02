package lotto.exception;

public class LottoProcessException extends IllegalArgumentException {
    private static final int LOTTO_PRICE = 1000;
    private static final int NON_PURCHASE_PRICE = 0;

    public LottoProcessException(String message) {
        super(message);
    }

    public static void checkPurchaseMoney(int money) {
        if (money % LOTTO_PRICE != 0 || money <= NON_PURCHASE_PRICE) {
            String PRICE_ERROR_MESSAGE = "[ERROR] 로또 구입 금액은 " + LOTTO_PRICE + "원 단위의 양수여야 합니다.";
            throw new LottoProcessException(PRICE_ERROR_MESSAGE);
        }
    }
}
