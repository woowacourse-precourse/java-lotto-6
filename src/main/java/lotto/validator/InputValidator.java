package lotto.validator;

public class InputValidator{

    private static final Character ZERO_LETTER = '0';
    private static final int LEAST_LENGTH = 1;
    public static void validate(String input) {
        validateBlank(input);
        validateNonNumber(input);
        validateStartsWithZero(input);
        validateIntegerRange(input);
        validateCheckNegativeValue(input);
    }

    private static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 공백일 수 없습니다.");
        }
    }

    private static void validateNonNumber(String input) {
        String regExp = "^[0-9-]+$";
        if (!input.matches(regExp)){
            throw new IllegalArgumentException("[ERROR] 입력 값에 숫자 이외의 값이 들어오면 안됩니다.");
        }
    }

    private static void validateStartsWithZero(String input) {
        if (input.length() != LEAST_LENGTH && input.charAt(0) == ZERO_LETTER){
            throw new IllegalArgumentException("[ERROR] 입력 값이 두자리 수 이상일 때 첫 글자가 0이면 안됩니다.");
        }
    }

    private static void validateIntegerRange(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 정수 값을 입력하세요.");
        }
    }

    private static void validateCheckNegativeValue(String input) {
        try {
            int parsedInput = Integer.parseInt(input);
            if (parsedInput < 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 0보다 작을 수 없습니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 정수 값을 입력하세요.");
        }
    }
}
