package lotto.validator;

public class InputValidator implements Validator<String>{

    @Override
    public void validate(String input) {
        validateBlank(input);
        validateNonNumber(input);
        validateIntegerRange(input);
        validateCheckNegativeValue(input);
    }

    private static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 공백일 수 없습니다");
        }
    }

    private static void validateNonNumber(String input) {
        String regExp = "^[0-9-]+$";
        if (!input.matches(regExp)){
            throw new IllegalArgumentException("[ERROR] 입력 값에 숫자 이외의 값이 들어오면 안됩니다.");
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
        int parsedInput = Integer.parseInt(input);
        if (parsedInput < 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0보다 작을 수 없습니다.");
        }
    }
}
