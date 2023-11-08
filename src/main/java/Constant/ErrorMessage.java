package Constant;

public enum ErrorMessage {
    INCORRECT_NUMBER_OF_NUMBERS("[ERROR] 로또 번호는 6개의 숫자로 이루어져 있어야합니다."),
    DUPLICATION_OF_NUMBERS("[ERROR] 중복된 숫자가 입력되었습니다."),
    INVALID_NUMBER_OF_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_NUMBER_OF_UNITS("[ERROR] 1000원 단위가 아닌 값을 입력되었습니다."),
    NON_NUMERIC_VALUE("[ERROR] 입력된 값이 숫자가 아닙니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
