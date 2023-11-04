package lotto.exception;

public enum Validator {
    VALIDATOR(new InputExceptionValidator());

    private final InputExceptionValidator inputExceptionValidator;

    private Validator(InputExceptionValidator inputExceptionValidator) {
        this.inputExceptionValidator = inputExceptionValidator;
    }

    public InputExceptionValidator getInputValidator() {
        return inputExceptionValidator;
    }
}
