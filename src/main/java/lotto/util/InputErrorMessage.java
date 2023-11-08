package lotto.util;

public enum InputErrorMessage {
    NOT_A_NUMBER("[ERROR] 숫자를 입력하세요."),
    COMMA_DELIMITER("[ERROR] 번호는 쉼표(,)를 기준으로 구분해주세요. (ex.1,2,3,4,5,6)"),
    DUPLICATE_NUMBERS("[ERROR] 중복되지 않는 숫자 6개를 입력해주세요."),
    INVALID_VALUE_LENGTH("[ERROR] 6개의 숫자를 입력해주세요."),
    INVALID_VALUE_RANGE("[ERROR] 1~45 사이의 값을 선택하세요."),
    NOT_AN_INTEGER("[ERROR] 숫자 이외의 값은 입력할 수 없습니다.");

    private final String message;

    InputErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

