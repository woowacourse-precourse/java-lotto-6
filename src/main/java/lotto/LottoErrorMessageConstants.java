package lotto;

public enum LottoErrorMessageConstants {
    PURCHASE_PRICE_NOT_NUMBER_INPUT_ERROR_MESSAGE("[ERROR] 로또 구입금액은 숫자여야 합니다."),
    PURCHASE_PRICE_NOT_INDIVISIBLE_PRICE_ERROR_MESSAGE("[ERROR] 로또 구입금액은 " + LottoConstants.LOTTO_PRICE
            + "원에 나누어 떨어져야 합니다."),
    WINNER_NUMBER_INVALID_INPUT_ERROR_MESSAGE("[ERROR] 당첨 번호는 숫자여야 합니다."),
    WINNER_NUMBER_INVALID_NUMBER_ERROR_MESSAGE("[ERROR] 당첨 번호는 " + LottoConstants.LOTTO_START_NUMBER
            + "이상 " + LottoConstants.LOTTO_END_NUMBER + " 이하의 숫자를 '"
            + LottoSeparatorConstant.LOTTO_INPUT_SEPARATOR.getConstant()
            + "'로 구분하여" + LottoConstants.LOTTO_PER_NUMBERS + "개를 입력해야 합니다.");
    private final String message;

    LottoErrorMessageConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
