package lotto.exception;

public enum Validator {
    VALIDATOR(new InputExceptionValidator(), new LottoExceptionValidator());

    private final InputExceptionValidator inputExceptionValidator;
    private final LottoExceptionValidator lottoExceptionValidator;

    private Validator(InputExceptionValidator inputExceptionValidator, LottoExceptionValidator lottoExceptionValidator) {
        this.inputExceptionValidator = inputExceptionValidator;
        this.lottoExceptionValidator = lottoExceptionValidator;
    }

    public InputExceptionValidator getInputValidator() {
        return inputExceptionValidator;
    }

    public LottoExceptionValidator getLottoValidator() {
        return lottoExceptionValidator;
    }
}
