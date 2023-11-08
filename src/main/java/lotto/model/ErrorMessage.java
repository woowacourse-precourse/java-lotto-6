package lotto.model;

public enum ErrorMessage {

    PURCHASE_PRICE_UNIT_ERROR("[ERROR] 구입 금액을 1,000원 단위로 입력하세요."),
    BLANK_ERROR("[ERROR] 숫자를 입력하세요."),
    CONTAIN_SYMBOL_ERROR("[ERROR] 숫자만 입력하세요."),
    NUMBER_RANGE_ERROR("[ERROR] 1에서 45 사이의 숫자만 입력하세요."),
    NUMBER_COUNT_ERROR("[ERROR] 숫자를 6개 입력하세요.");

    private final String getErrorMessage;

    ErrorMessage(String error) {
        getErrorMessage = error;
    }

    @Override
    public String toString() {
        return getErrorMessage;
    }
}
