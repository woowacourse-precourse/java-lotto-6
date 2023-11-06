package lotto.validator;

import static lotto.config.InputPattern.PURCHASE_AMOUNT_REGEX;
import static lotto.config.LottoConfig.PURCHASE_AMOUNT_MAX;
import static lotto.config.LottoConfig.PURCHASE_DIVISIBLE_AMOUNT;
import static lotto.config.PurchaseErrorMessage.PURCHASE_AMOUNT_MAX_ERROR_MESSAGE;
import static lotto.config.PurchaseErrorMessage.PURCHASE_BLANK_ERROR_MESSAGE;
import static lotto.config.PurchaseErrorMessage.PURCHASE_DIVISIBLE_ERROR_MESSAGE;
import static lotto.config.PurchaseErrorMessage.PURCHASE_NUMERIC_ERROR_MESSAGE;
import static lotto.config.PurchaseErrorMessage.PURCHASE_STARTS_ZERO_ERROR_MESSAGE;

import java.util.regex.Pattern;

public class PurchaseAmountValidator implements Validator<String> {
    private static final Pattern PURCHASE_AMOUNT_PATTERN = Pattern.compile(PURCHASE_AMOUNT_REGEX.getRegex());

    @Override
    public String validate(String input) {
        notBlank(input);
        numeric(input);
        notStartsZero(input);
        range(input);
        divisibleByUnit(input);

        return input;
    }

    private void notBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(PURCHASE_BLANK_ERROR_MESSAGE.getMessage());
        }
    }

    private void numeric(String input) {
        if (!PURCHASE_AMOUNT_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(PURCHASE_NUMERIC_ERROR_MESSAGE.getMessage());
        }
    }

    private void notStartsZero(String input) {
        if (input.startsWith("0")) {
            throw new IllegalArgumentException(PURCHASE_STARTS_ZERO_ERROR_MESSAGE.getMessage());
        }
    }

    private void divisibleByUnit(String input) {
        int amount = parseInt(input);

        if (amount % PURCHASE_DIVISIBLE_AMOUNT.getValue() != 0) {
            throw new IllegalArgumentException(PURCHASE_DIVISIBLE_ERROR_MESSAGE.getMessage());
        }
    }

    private void range(String input) {
        int amount = parseInt(input);

        if (amount > PURCHASE_AMOUNT_MAX.getValue()) { // 최소 구매 검증은 divisibleByUnit() 에서 자동으로 검증됨
            throw new IllegalArgumentException(PURCHASE_AMOUNT_MAX_ERROR_MESSAGE.getMessage());
        }
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PURCHASE_NUMERIC_ERROR_MESSAGE.getMessage());
        }
    }
}
