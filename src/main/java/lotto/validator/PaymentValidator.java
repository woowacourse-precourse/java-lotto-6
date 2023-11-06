package lotto.validator;

public final class PaymentValidator {

    private static final int LOTTO_PRICE = 1000;
    private static final int MAX_AMOUNT = 2_000_000_000;
    private static final String NUMBER_ERROR_MESSAGE = "[ERROR] 구입 금액은 숫자만 입력할 수 있습니다.";
    private static final String MIN_AMOUNT_ERROR_MESSAGE = "[ERROR] 최소 구입 금액은 1,000원 입니다.";
    private static final String UNIT_ERROR_MESSAGE = "[ERROR] 구입 금액은 1,000원 단위 입니다.";
    private static final String MAX_AMOUNT_ERROR_MESSAGE = "[ERROR] 최대 구입 금액은 2,000,000,000원 입니다.";

    private PaymentValidator() {
    }

    public static void validate(final String amount) {
        validateOnlyNumberExist(amount);
        validateMinimumAmount(amount);
        validateThousandUnit(amount);
        validateMaximumAmount(amount);
    }

    private static void validateOnlyNumberExist(final String amount) {
        try {
            Integer.parseInt(amount);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
        }
    }

    private static void validateMinimumAmount(final String amount) {
        if (Integer.parseInt(amount) < LOTTO_PRICE) {
            throw new IllegalArgumentException(MIN_AMOUNT_ERROR_MESSAGE);
        }
    }

    private static void validateThousandUnit(final String amount) {
        if (isThousandUnit(amount)) {
            throw new IllegalArgumentException(UNIT_ERROR_MESSAGE);
        }
    }

    private static boolean isThousandUnit(final String amount) {
        return Integer.parseInt(amount) % LOTTO_PRICE != 0;
    }

    private static void validateMaximumAmount(final String amount) {
        if (Integer.parseInt(amount) > MAX_AMOUNT) {
            throw new IllegalArgumentException(MAX_AMOUNT_ERROR_MESSAGE);
        }
    }

}
