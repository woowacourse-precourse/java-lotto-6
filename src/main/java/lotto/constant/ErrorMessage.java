package lotto.constant;

import static lotto.model.LottoInfo.LOTTO_MAX_NUMBER;
import static lotto.model.LottoInfo.LOTTO_MIN_NUMBER;
import static lotto.model.LottoInfo.LOTTO_SIZE;
import static lotto.model.LottoInfo.ONE_LOTTO_PRICE;

public enum ErrorMessage {

    ERROR_SIGNATURE("[ERROR]"),

    LOTTO_MIN_PRICE_ERROR_MESSAGE(String.format("%s 로또는 %s원 이상부터 구매 가능합니다",
            ERROR_SIGNATURE,
            ONE_LOTTO_PRICE)),

    REMAINING_CHANGE_ERROR_MESSAGE(String.format("%s 로또는 %s원 단위로 구입이 가능합니다.",
            ERROR_SIGNATURE,
            ONE_LOTTO_PRICE)),

    LARGER_THAN_MAX_LOTTO_NUMBER_ERROR_MESSAGE(String.format("%s 로또 번호는 %s보다 같거나 작아야 합니다.",
            ERROR_SIGNATURE,
            LOTTO_MAX_NUMBER)),

    LOWER_THAN_MIN_LOTTO_NUMBER_ERROR_MESSAGE(String.format("%s 로또 번호는 %s 보다 같거나 커야 합니다.",
            ERROR_SIGNATURE,
            LOTTO_MIN_NUMBER)),

    INVALID_LOTTO_SIZE_ERROR_MESSAGE(String.format("%s 로또 번호는 %s개 입력 하셔야 합니다.",
            ERROR_SIGNATURE,
            LOTTO_SIZE)),

    DUPLICATE_LOTTO_NUMBER_ERROR_MESSAGE(String.format("%s 중복된 번호가 존재합니다.",
            ERROR_SIGNATURE)),

    EMPTY_INPUT_ERROR_MESSAGE(String.format("%s 빈 값은 허용되지 않습니다.",
            ERROR_SIGNATURE)),

    CHARACTER_INPUT_ERROR_MESSAGE(String.format("%s 문자는 입력값에 들어올 수 없습니다.",
            ERROR_SIGNATURE)),

    NEGATIVE_OR_ZERO_INPUT_ERROR_MESSAGE(String.format("%s 0 또는 음수는 입력할 수 없습니다.",
            ERROR_SIGNATURE)),

    BONUS_NUMBER_CONTAINS_WINNING_ERROR_MESSAGE(String.format("%s 입력하신 보너스 숫자는 당첨 번호에 속한 번호입니다.",
            ERROR_SIGNATURE));

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
