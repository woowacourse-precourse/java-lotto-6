package lotto.exception;

public enum Errors {
    INVALID_SIZE("올바른 로또번호의 갯수가 아닙니다.");

    private final String message;

    Errors(String message) {
        this.message = message;
    }

    public LottoException getException() {
        return new LottoException(this.message);
    }

}
