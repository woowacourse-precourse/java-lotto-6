package lotto.model;

public enum ErrorMessage {

    PURCHASE_PRICE_UNIT_ERROR(1, "[ERROR] 구입 금액을 1,000원 단위로 입력하세요."),
    BLANK_ERROR(2, "[ERROR] 숫자를 입력하세요."),
    CONTAIN_SYMBOL_ERROR(3, "[ERROR] 숫자만 입력하세요."),
    NUMBER_RANGE_ERROR(4, "[ERROR] 1에서 45 사이의 숫자만 입력하세요."),
    NUMBER_COUNT_ERROR(5, "[ERROR] 숫자를 6개 입력하세요.");

    private final int errorNumber;
    private final String getErrorMessage;

    ErrorMessage(int number, String error) {
        errorNumber = number;
        getErrorMessage = error;
    }

    @Override
    public String toString() {
        return getErrorMessage;
    }

    public int getErrorNumber() {
        return errorNumber;
    }
}
