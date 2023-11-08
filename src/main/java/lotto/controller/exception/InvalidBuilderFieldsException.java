package lotto.controller.exception;

public final class InvalidBuilderFieldsException extends IllegalStateException {
    public static final String INVALID_BUILDER_FIELDS_EXCEPTION_MESSAGE = "빌더에 누락된 필드가 존재합니다.";

    public InvalidBuilderFieldsException() {
        super(INVALID_BUILDER_FIELDS_EXCEPTION_MESSAGE);
    }
}
