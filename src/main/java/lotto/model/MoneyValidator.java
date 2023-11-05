package lotto.model;

public class MoneyValidator {

    private static final String MONEY_UNIT_EXCEPTION_MESSAGE = "[ERROR] 입력 금액은 1000원 단위여야 합니다.";

    private MoneyValidator() {
    }

    public static void validateMoney(final int money) {
        if (isNotMultipleOfUnit(money)) {
            throw new IllegalArgumentException(MONEY_UNIT_EXCEPTION_MESSAGE);
        }
    }

    private static boolean isNotMultipleOfUnit(final int money) {
        return money % LottoConstants.LOTTO_PRICE_UNIT != 0;
    }
}
