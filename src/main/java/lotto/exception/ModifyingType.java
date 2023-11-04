package lotto.exception;

public enum ModifyingType {
    MONEY_NUMBER("구입 금액"),
    LOTTO_NUMBER("로또 번호"),
    BONUS_NUMBER("보너스 번호")
    ;

    ModifyingType(String errorType) {
        this.errorType = errorType;
    }

    private final String errorType;

    public String getErrorType() {
        return errorType;
    }
}
