package lotto.constant;

public enum ErrorMessage {
    MONEY_ERROR_MESSAGE("[ERROR] 구입금액은 1000원으로 나누어 떨어져야 합니다."),
    NOT_ENOUGH_MONEY_ERROR_MESSAGE("[ERROR] 로또를 구매할 수 없습니다."),
    RANGE_ERROR_MESSAGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NOT_INT_ERROR_MESSAGE("[ERROR] 구입금액은 숫자여야 합니다."),
    NOT_SIX_NUMBER_ERROR_MESSAGE("[ERROR] 당첨 번호는 6자리 숫자입니다."),
    DUPLICATE_ERROR_MESSAGE("[ERROR] 숫자가 중복됩니다.");


    private final String errorMessage;

    private ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
