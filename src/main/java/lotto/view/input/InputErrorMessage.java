package lotto.view.input;

public enum InputErrorMessage {
    NOT_NUMBER_ERROR("[ERROR] 숫자만 입력할 수 있습니다."),
    INVALID_DELIMITER_ERROR("[ERROR] 쉼표(,)로 숫자들을 구분해주세요."),
    EMPTY_INPUT_ERROR("[ERROR] 입력이 비어있습니다.");

    private final String message;

    InputErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
