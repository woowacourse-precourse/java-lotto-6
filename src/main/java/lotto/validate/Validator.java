package lotto.validate;

import java.util.regex.Pattern;

public abstract class Validator {
    private static final String INVALID_NATURAL_NUMBER = "[ERROR] 자연수가 아닙니다.";
    private static final String INVALID_NUMBER_RANGE = "[ERROR] 정해진 범위의 숫자가 아닙니다.";
    private static final String INVALID_DIVISIBLE = "[ERROR] 1,000으로 나누어 떨어지는 숫자가 아닙니다.";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int THOUSAND_WON = 1000;

    private static final String ONLY_NUMBER_REGEX = "^[0-9]*$";

    abstract void validate(String input) throws IllegalArgumentException;

    void validateNaturalNumber(String input) {
        if(!Pattern.matches(ONLY_NUMBER_REGEX, input)) {
            throw new IllegalArgumentException(INVALID_NATURAL_NUMBER);
        }
    }

    void validateLottoRange(String input) {
        int number = Integer.parseInt(input);
        if (number <= MIN_NUMBER || number >= MAX_NUMBER) {
            throw  new IllegalArgumentException(INVALID_NUMBER_RANGE);
        }
    }

    void validateIntRange(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE);
        }
    }

    void validateDivisibleByThousand(String input) {
        int number = Integer.parseInt(input);
        if(number % THOUSAND_WON != 0) {
            throw new IllegalArgumentException(INVALID_DIVISIBLE);
        }
    }
}
