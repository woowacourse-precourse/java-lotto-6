package lotto.domain;

public class LottoMoney {

    private static final String NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 숫자를 입력해 주세요.";
    private static final String NOT_DIVISIBLE_BY_1000_ERROR_MESSAGE = "[ERROR] 1000원 단위로 입력해 주세요.";
    private static final String NOT_POSITIVE_NUMBER_ERROR_MESSAGE = "[ERROR] 0보다 큰 숫자를 입력해 주세요.";

    private int money;

    public LottoMoney(String input) {
        this.money = validate(input);
    }

    private int validate(String input) {
        int integerMoney = validateCorrectNumber(input);
        validateDivisibleBy1000(integerMoney);
        validatePositiveNumber(integerMoney);
        return integerMoney;
    }

    private int validateCorrectNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE);
        }
    }

    private void validateDivisibleBy1000(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_BY_1000_ERROR_MESSAGE);
        }
    }

    private void validatePositiveNumber(int money) {
        if (money < 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER_ERROR_MESSAGE);
        }
    }
}
