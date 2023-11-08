package lotto.enums;

public enum ErrorMessages {

    ONLY_NUMBER("입력값은 숫자만 가능합니다."),
    NOT_EMPTY("반드시 입력 값이 있어야 합니다."),
    IN_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NOT_DUPLICATE("로또 번호는 중복되면 안됩니다."),
    PURCHASE_UNIT("구매 금액은 1,000원 단위로만 입력 가능합니다."),
    PURCHASE_LEAST("구매 금액은 최소 1000원부터 가능합니다.");


    private final String errorMessage;
    private final String errorPrefix = "[ERROR] ";

    ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return this.errorPrefix + this.errorMessage;
    }
}
