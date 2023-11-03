package lotto.domain;

import java.util.regex.Pattern;

public class PurchaseAmount {

    private static final int LOTTO_PRICE = 1000;
    private static final String NON_NUMERIC_ERROR_MESSAGE = "[ERROR] 숫자로만 이루어진 값을 입력해주세요.";
    private static final String WRONG_UNIT_ERROR_MESSAGE = "[ERROR] 입력 금액은 1,000원 단위여야 합니다.";
    private final String amount;

    public PurchaseAmount(String amount) {
        validateNonNumeric(amount);
        validateUnit(amount);
        this.amount = amount;
    }

    public String getAmount() {
        return amount;
    }

    private void validateNonNumeric(String input) {
        String pattern = "^[0-9]*$";
        if (!Pattern.matches(pattern, input)) {
            throw new IllegalArgumentException(NON_NUMERIC_ERROR_MESSAGE);
        }
    }

    private void validateUnit(String input) {
        int num = Integer.parseInt(input);
        if (num % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(WRONG_UNIT_ERROR_MESSAGE);
        }
    }
}
