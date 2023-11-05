package lotto.view;

public enum ErrorMessage {
    //ERROR
    NUMBER_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_ERROR("[ERROR] 중복된 숫자가 있습니다."),
    TYPE_ERROR("[ERROR] 옳지 않은 형식입니다."),
    LENGTH_ERROR("[ERROR] 6자리의 번호를 입력해주세요."),
    EMPTY_ERROR("[ERROR] 비어 있는 숫자가 있습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
