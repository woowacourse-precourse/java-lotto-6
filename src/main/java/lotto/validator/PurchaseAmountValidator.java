package lotto.validator;

import java.util.regex.Pattern;

public class PurchaseAmountValidator implements Validator<String> {
    private static final int PURCHASE_AMOUNT_MAX = 100000;
    private static final String PURCHASE_AMOUNT_REGEX = "^[0-9]+$";
    private static final Pattern PURCHASE_AMOUNT_PATTERN = Pattern.compile(PURCHASE_AMOUNT_REGEX);
    private static final String PURCHASE_BLANK_ERROR_MESSAGE = "[ERROR] 로또 구입 금액이 없거나 공백만 입력하였습니다.";
    private static final String PURCHASE_NUMERIC_ERROR_MESSAGE = "[ERROR] 로또 구입 금액은 숫자만 입력해야 합니다.";
    private static final String PURCHASE_STARTS_ZERO_ERROR_MESSAGE = "[ERROR] 첫 문자가 0이 아니어야 합니다.";
    private static final String PURCHASE_DIVISIBLE_ERROR_MESSAGE = "[ERROR] 로또 구입 금액은 1000원 단위로 입력해야 합니다.";
    private static final String PURCHASE_AMOUNT_MAX_ERROR_MESSAGE =
            "[ERROR] 로또 구입 금액은 복권 및 복권 기금법 제5조 2항, 시행령 제3조에 따라 최대 100000원 까지만 구매 가능합니다.";
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
            throw new IllegalArgumentException(PURCHASE_BLANK_ERROR_MESSAGE);
        }
    }

    private void numeric(String input) {
        if (!PURCHASE_AMOUNT_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(PURCHASE_NUMERIC_ERROR_MESSAGE);
        }
    }

    private void notStartsZero(String input) {
        if (input.startsWith("0")) {
            throw new IllegalArgumentException(PURCHASE_STARTS_ZERO_ERROR_MESSAGE);
        }
    }

    private void divisibleByUnit(String input) {
        int amount = parseInt(input);

        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(PURCHASE_DIVISIBLE_ERROR_MESSAGE);
        }
    }

    private void range(String input) {
        int amount = parseInt(input);

        if (amount > PURCHASE_AMOUNT_MAX) { // 최소 구매 검증은 divisibleByUnit() 에서 자동으로 검증됨
            throw new IllegalArgumentException(PURCHASE_AMOUNT_MAX_ERROR_MESSAGE);
        }
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PURCHASE_NUMERIC_ERROR_MESSAGE);
        }
    }
}
