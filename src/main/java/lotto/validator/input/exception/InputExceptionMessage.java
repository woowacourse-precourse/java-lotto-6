package lotto.validator.input.exception;

public enum InputExceptionMessage {

    INVALID_NUMBER_FORMAT("[ERROR] 숫자만 입력해야 합니다.");

    private final String value;

    InputExceptionMessage(final String value) {
        this.value = value;
    }

    public InputIllegalArgumentException create() {
        return new InputIllegalArgumentException(value);
    }
}
