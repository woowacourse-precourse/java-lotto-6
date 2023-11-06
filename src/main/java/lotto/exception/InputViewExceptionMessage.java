package lotto.exception;

public enum InputViewExceptionMessage {
    NOT_NUMBER("[ERROR] 숫자 이외의 값을 입력할 수 없습니다."),
    NO_LINE_FOUND("[ERROR] 입력값을 입력하지 않았습니다."),
    FOUND_SPECIAL_SIGN("[ERROR] 입력값에 구분자인,(쉼표) 이 외의 특수문자를 허용하지 않습니다."),

    WRONG_NUMBER_FORMAT("[ERROR] 잘못된 숫자 형식입니다.");
    private final String message;

    InputViewExceptionMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
