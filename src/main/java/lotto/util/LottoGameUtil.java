package lotto.util;

public class LottoGameUtil {

    private static final int PURCHASE_AMOUNT_FORMAT = 1000;
    private static final int ZERO = 0;

    private LottoGameUtil() {}

    public static void validPurchaseAmountFormat(String amount) {
        if (Integer.parseInt(amount) % PURCHASE_AMOUNT_FORMAT != ZERO) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 나누어 떨어져야 합니다.");
        }
    }

    public static int convertPurchaseAmount(String amount) {
        validPurchaseAmountFormat(amount);
        return Integer.parseInt(amount) / PURCHASE_AMOUNT_FORMAT;
    }
}
