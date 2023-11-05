package lotto.manager;

public enum Exception {
    PURCHASE_AMOUNT_OUT_OF_RANGE("[ERROR] 구입금액은 1000원 미만일 수 없습니다."),
    PURCHASE_AMOUNT_WRONG_UNIT("[ERROR] 구입금액은 1000원 단위로 입력해주세요.");

    private final String errorMessage;

    Exception(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void throwing() {
        throw new IllegalArgumentException(errorMessage);
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
