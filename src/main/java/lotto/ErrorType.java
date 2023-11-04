package lotto;

public enum ErrorType {
    LOTTO_NUMBER("로또 번호"),
    BONUS_NUMBER("보너스 번호")
    ;

    ErrorType(String errorType) {
        this.errorType = errorType;
    }

    private final String errorType;

    public String getErrorType() {
        return errorType;
    }
}
