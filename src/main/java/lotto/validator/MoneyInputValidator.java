package lotto.validator;

public class MoneyInputValidator implements BasicValidator<String> {

    private static final String INPUT_NOT_NUMERIC = "[ERROR] 입력값이 숫자가 아닙니다.";
    private static final String INPUT_NOT_POSITIVE = "[ERROR] 입력값이 0보다 커야 합니다.";
    private static final String INPUT_NOT_MULTIPLE_OF_THOUSAND = "[ERROR] 로또 구입 금액은 1000원 단위로 가능합니다.";
    private static final String INPUT_NOT_MORE_THAN_ONE_THOUSAND = "[ERROR] 로또 구입 금액은 최소 1000원 이상이어야 합니다.";

    @Override
    public void validate(String input) {
        isNumeric(input);
        isPositive(input);
        isMultipleOfThousand(input);
        isMoreThanOneThousand(input);
    }

    private void isNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_NOT_NUMERIC);
        }
    }

    private void isPositive(String input) {
        int money = Integer.parseInt(input);
        if (money <= 0) {
            throw new IllegalArgumentException(INPUT_NOT_POSITIVE);
        }
    }

    private void isMultipleOfThousand(String input) {
        int money = Integer.parseInt(input);
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(INPUT_NOT_MULTIPLE_OF_THOUSAND);
        }
    }

    private void isMoreThanOneThousand(String input) {
        int money = Integer.parseInt(input);
        if (money < 1000) {
            throw new IllegalArgumentException(INPUT_NOT_MORE_THAN_ONE_THOUSAND);
        }
    }
}