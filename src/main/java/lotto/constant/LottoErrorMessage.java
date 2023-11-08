package lotto.constant;

public enum LottoErrorMessage {
    PURCHASE_AMOUNT_NOT_A_NUMBER_ERROR_MESSAGE("%s 구입금액은 1000이상의 자연수여야 합니다."),
    PURCHASE_AMOUNT_DIVIDE_ERROR_MESSAGE("%s 구입금액은 1000단위로 나누어 떨어져야 합니다."),
    LOTTO_LENGTH_ERROR_MESSAGE("%s 로또 번호의 개수는 6개여야 합니다."),
    LOTTO_NUMBER_ERROR_MESSAGE("%s 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE("%s 로또 번호는 중복이 될 수 없습니다.");

    private final String errorMessage;

    LottoErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
