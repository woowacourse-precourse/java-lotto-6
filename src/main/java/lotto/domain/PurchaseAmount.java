package lotto.domain;

import java.util.regex.Pattern;

public class PurchaseAmount {
    private final String amount;
    private static final String NON_NUMERIC_ERROR_MESSAGE = "[ERROR] 숫자로만 이루어진 값을 입력해주세요.";

    public PurchaseAmount(String amount) {
        validateNonNumeric(amount);
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
}
