package lotto;

public class InputValidator {

    private static final String ERROR_BLANK = "[ERROR] 입력된 값이 없습니다.";
    private static final String ERROR_NOT_NUMBER = "[ERROR] 숫자를 입력해야합니다.";
    private static final String ERROR_NOT_MULTIPLE_1000 = "[ERROR] 1000단위로 나누어 떨어지는 숫자가 아닙니다.";

    public static void validateBlank(String input) {
        if(input.isBlank()){
            throw new IllegalArgumentException(ERROR_BLANK);
        }
    }

    public static void validateNumbers(String input) {
        if(!input.matches("^[1-9]\\d*$")){
            throw new IllegalArgumentException(ERROR_NOT_NUMBER);
        }
    }

    public static void validateIsMultipleOf1000(String input) {
        if(Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_NOT_MULTIPLE_1000);
        }
    }
}
