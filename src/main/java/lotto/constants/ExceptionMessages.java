package lotto.constants;

public enum ExceptionMessages {
    PURCHASE_AMOUNT_TYPE_ERROR_MESSAGE("[ERROR] 숫자로 이루어진 값을 입력해주세요"),
    PURCHASE_AMOUNT_RANGE_ERROR_MESSAGE("[ERROR] 1000원 단위의 올바른 금액을 입력해주세요");
    private final String errorMessage;
    ExceptionMessages(String message) {
        this.errorMessage = message;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
}
