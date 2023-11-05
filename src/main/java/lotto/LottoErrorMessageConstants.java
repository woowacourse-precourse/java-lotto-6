package lotto;

public enum LottoErrorMessageConstants {
    PURCHASE_PRICE_NOT_NUMBER_INPUT_ERROR_MESSAGE("[ERROR] 로또 구입금액은 숫자여야 합니다."),
    PURCHASE_PRICE_NOT_INDIVISIBLE_PRICE_ERROR_MESSAGE("[ERROR] 로또 구입금액은 " + LottoConstants.LOTTO_PRICE
            + "원에 나누어 떨어져야 합니다."),
    BONUS_NUMBER_INVALID_INPUT_ERROR_MESSAGE("[ERROR] 로또 번호는 " + LottoConstants.LOTTO_START_NUMBER
            + "부터 " + LottoConstants.LOTTO_END_NUMBER + " 사이의 숫자여야 합니다.");
    private final String message;

    LottoErrorMessageConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
