package lotto.util;

public enum ErrorMessage {

    INPUT_STRING_ERROR("[ERROR] 입력된 정보는 정수가 아닌 문자열 입니다."),
    INPUT_MULTIPLES_OF_1000_ERROR("[ERROR] 입력된 정수는 1000의 배수가 아닙니다.");

    private String message;

    public String getMessage() {
        return message;
    }

    ErrorMessage(String message) {
        this.message = message;
    }
}
