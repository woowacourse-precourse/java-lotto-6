package lotto.model;

public class MoneyValidator {

    private static final String MONEY_UNIT_EXCEPTION_MESSAGE = "[ERROR] 입력 금액은 1000원 단위여야 합니다.";
    private static final String NEGATIVE_AMOUNT_EXCEPTION_MESSAGE = "[ERROR] 입력 금액은 음수이면 안 됩니다.";

    private MoneyValidator() {
    }

    public static void validateMoney(final int money) {
        validateMultipleOfThousand(money);
        validateNegativeAmount(money);
    }

    private static void validateMultipleOfThousand(final int money) {
        if (isNotMultipleOfUnit(money)) {
            throw new IllegalArgumentException(MONEY_UNIT_EXCEPTION_MESSAGE);
        }
    }

    private static boolean isNotMultipleOfUnit(final int money) {
        return money % LottoConstants.LOTTO_PRICE_UNIT != 0;
    }

    private static void validateNegativeAmount(final int money) {
        if (money < 0) {
            throw new IllegalArgumentException(NEGATIVE_AMOUNT_EXCEPTION_MESSAGE);
        }
    }
}
