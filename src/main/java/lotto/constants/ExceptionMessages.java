package lotto.constants;

public enum ExceptionMessages {
    PURCHASE_AMOUNT_TYPE_ERROR_MESSAGE("[ERROR] 숫자로 이루어진 값을 입력해주세요"),
    PURCHASE_AMOUNT_RANGE_ERROR_MESSAGE("[ERROR] 1000원 단위의 올바른 금액을 입력해주세요"),
    LOTTO_NUMBER_RANGE_ERROR_MESSAGE("[ERROR] 로또 번호의 숫자 범위는 1~45까지 입니다. "),
    LOTTO_NUMBER_COUNT_ERROR_MESSAGE("[ERROR] 로또 번호의 개수는 6개 입니다."),
    LOTTO_NUMBER_TYPE_ERROR_MESSAGE("[ERROR] 로또 번호는 숫자로만 이루어져야 합니다."),
    LOTTO_NUMBER_DUPLICATION_ERROR_MESSAGE("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
    private final String errorMessage;

    ExceptionMessages(String message) {
        this.errorMessage = message;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
