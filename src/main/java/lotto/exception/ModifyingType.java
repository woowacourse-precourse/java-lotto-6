package lotto.exception;

public enum ModifyingType {
    MONEY_NUMBER("구입 금액을 다시 입력해주세요."),
    LOTTO_NUMBER("로또 번호을 다시 입력해주세요."),
    BONUS_NUMBER("보너스 번호를 다시 입력해주세요..")
    ;

    ModifyingType(String errorType) {
        this.errorType = errorType;
    }

    private final String errorType;

    public String getErrorType() {
        return errorType;
    }
}
