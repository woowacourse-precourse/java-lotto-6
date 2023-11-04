package lotto.controller.exception;

public final class NumericInputValidationException extends IllegalArgumentException {
    public static final String NUMERIC_INPUT_VALIDATION_EXCEPTION = "반드시 숫자로만 이루어진 문자열을 입력해야 합니다.";

    public NumericInputValidationException() {
        super(NUMERIC_INPUT_VALIDATION_EXCEPTION);
    }
}
