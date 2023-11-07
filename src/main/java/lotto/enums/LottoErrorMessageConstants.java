package lotto.enums;

public enum LottoErrorMessageConstants {
    LOTTO_INVALID_SIZE("[ERROR] 로또의 숫자는 " + LottoConstants.LOTTO_PER_NUMBERS.getConstant() + "개 입력되어야 합니다."),
    LOTTO_HAS_DUPLICATE_NUMBER("[ERROR] 로또의 숫자는 중복이 없어야 합니다."),
    PURCHASE_PRICE_NOT_INDIVISIBLE_PRICE_ERROR_MESSAGE("[ERROR] 로또 구입금액은 " + LottoConstants.LOTTO_PRICE
            + "원에 나누어 떨어져야 합니다."),
    INPUT_NOT_NUMBER_ERROR_MESSAGE("[ERROR] 해당 입력은 숫자여야 합니다."),
    WINNING_NUMBER_DUPLICATE_INPUT_ERROR_MESSAGE("[ERROR] 당첨 번호는 중복된 숫자가 없습니다."),
    WINNING_NUMBER_INVALID_NUMBER_ERROR_MESSAGE("[ERROR] 당첨 번호는 " + LottoConstants.LOTTO_START_NUMBER
            + "이상 " + LottoConstants.LOTTO_END_NUMBER + " 이하의 숫자를 '"
            + LottoSeparatorConstant.LOTTO_INPUT_SEPARATOR.getConstant()
            + "'로 구분하여" + LottoConstants.LOTTO_PER_NUMBERS + "개를 입력해야 합니다."),
    BONUS_NUMBER_INVALID_NUMBER_ERROR_MESSAGE("[ERROR] 보너스 번호는 " + LottoConstants.LOTTO_START_NUMBER
            + "이상 " + LottoConstants.LOTTO_END_NUMBER + " 이하의 숫자를 입력해야 합니다."),
    BONUS_NUMBER_IS_CONTAINS_WINNING_NUMBER("[ERROR] 입력한 보너스 번호는 이미 당첨 번호에 존재합니다.");
    private final String message;

    LottoErrorMessageConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
