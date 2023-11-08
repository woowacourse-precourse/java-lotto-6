package lotto.common.exception;

public enum InputErrorMessage {
    NOT_NULL("입력된 값은 NULL이 될 수 없습니다."),
    NOT_BLANK("입력된 값은 빈칸이 될 수 없습니다.");

    private final String errorMessage;

    InputErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
