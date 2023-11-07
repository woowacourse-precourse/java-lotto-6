package lotto.enums;

import static lotto.enums.LottoConstants.LOTTO_END_NUMBER;
import static lotto.enums.LottoConstants.LOTTO_PER_NUMBERS;
import static lotto.enums.LottoConstants.LOTTO_PRICE;
import static lotto.enums.LottoConstants.LOTTO_START_NUMBER;
import static lotto.enums.LottoSeparatorConstant.LOTTO_INPUT_SEPARATOR;

public enum LottoErrorMessageConstants {
    LOTTO_INVALID_SIZE("[ERROR] 로또의 숫자는 " + LOTTO_PER_NUMBERS.getConstant() + "개 입력되어야 합니다."),
    LOTTO_HAS_DUPLICATE_NUMBER("[ERROR] 로또의 숫자는 중복이 없어야 합니다."),
    PURCHASE_PRICE_NOT_INDIVISIBLE_PRICE_ERROR_MESSAGE("[ERROR] 로또 구입금액은 "
            + LOTTO_PRICE.getConstant() + "원에 나누어 떨어져야 합니다."),
    INPUT_NOT_NUMBER_ERROR_MESSAGE("[ERROR] 해당 입력은 숫자여야 합니다."),
    WINNING_NUMBER_DUPLICATE_INPUT_ERROR_MESSAGE("[ERROR] 당첨 번호는 중복된 숫자가 없습니다."),
    WINNING_NUMBER_INVALID_NUMBER_ERROR_MESSAGE("[ERROR] 당첨 번호는 " + LOTTO_START_NUMBER.getConstant()
            + "이상 " + LOTTO_END_NUMBER.getConstant() + " 이하의 숫자를 '" + LOTTO_INPUT_SEPARATOR.getConstant()
            + "'로 구분하여" + LOTTO_PER_NUMBERS.getConstant() + "개를 입력해야 합니다."),
    BONUS_NUMBER_INVALID_NUMBER_ERROR_MESSAGE("[ERROR] 보너스 번호는 " + LOTTO_START_NUMBER.getConstant()
            + "이상 " + LOTTO_END_NUMBER.getConstant() + " 이하의 숫자를 입력해야 합니다."),
    BONUS_NUMBER_IS_CONTAINS_WINNING_NUMBER("[ERROR] 입력한 보너스 번호는 이미 당첨 번호에 존재합니다."),
    MATCHING_NUMBER_INVALID("[Error] 일치하는 숫자의 입력이 올바르지 않습니다.");
    private final String message;

    LottoErrorMessageConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
