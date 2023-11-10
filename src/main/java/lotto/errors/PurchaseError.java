package lotto.errors;

public enum PurchaseError {

    NOT_NUMBER("[ERROR] 구입 금액은 숫자여야 합니다."),
    NEGATIVE_AMOUNT("[ERROR] 구입 금액은 양수여야 합니다."),
    NOT_MULTIPLE_OF_UNIT("[ERROR] 구입 금액은 %d원 단위여야 합니다.");

    private final String errorMessage;

    PurchaseError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
