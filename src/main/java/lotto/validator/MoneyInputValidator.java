package lotto.validator;

public class MoneyInputValidator implements BasicValidator<String> {

    private static final int LOTTO_PURCHASE_PRICE = 1000;
    private static final int ZERO = 0;
    private static final String INPUT_NOT_NUMERIC = "[ERROR] 입력값이 숫자가 아닙니다.";
    private static final String INPUT_NOT_POSITIVE = "[ERROR] 입력값이 0보다 커야 합니다.";
    private static final String INPUT_NOT_MULTIPLE_OF_THOUSAND = "[ERROR] 로또 구입 금액은 1000원 단위로 가능합니다.";
    private static final String INPUT_NOT_MORE_THAN_ONE_THOUSAND = "[ERROR] 로또 구입 금액은 최소 1000원 이상이어야 합니다.";

    @Override
    public void validate(String input) {
        validateNumberIfNumeric(input);
        validateNumberIfPositive(input);
        validateNumberIfMultipleOfThousand(input);
        validateNumberIfMoreThanOneThousand(input);
    }

    private void validateNumberIfNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_NOT_NUMERIC);
        }
    }

    private void validateNumberIfPositive(String input) {
        int money = Integer.parseInt(input);
        if (money <= ZERO) {
            throw new IllegalArgumentException(INPUT_NOT_POSITIVE);
        }
    }

    private void validateNumberIfMultipleOfThousand(String input) {
        int money = Integer.parseInt(input);
        if (isNotMultipleOfThousand(money)) {
            throw new IllegalArgumentException(INPUT_NOT_MULTIPLE_OF_THOUSAND);
        }
    }

    private boolean isNotMultipleOfThousand(int money) {
        return money % LOTTO_PURCHASE_PRICE != ZERO;
    }

    private void validateNumberIfMoreThanOneThousand(String input) {
        int money = Integer.parseInt(input);
        if (money < LOTTO_PURCHASE_PRICE) {
            throw new IllegalArgumentException(INPUT_NOT_MORE_THAN_ONE_THOUSAND);
        }
    }
}