package lotto.exception;

import static lotto.utils.constant.LottoConstant.LOTTO_MONEY_MAX;
import static lotto.utils.constant.LottoConstant.LOTTO_MONEY_MIN;
import static lotto.utils.constant.LottoConstant.LOTTO_MONEY_UNIT;
import static lotto.utils.constant.LottoConstant.LOTTO_NUMBER_COUNT;
import static lotto.utils.constant.LottoConstant.LOTTO_NUMBER_MAX;
import static lotto.utils.constant.LottoConstant.LOTTO_NUMBER_MIN;

public enum ExceptionMessage {

    EXCEPTION_PREFIX("[ERROR] "),
    BONUS_NUMBER_DUPLICATION("보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    WINNING_NUMBER_DUPLICATION("당첨 번호는 중복될 수 없습니다."),
    LOTTO_NUMBER_OUT_OF_RANGE(
            "로또 번호는 %d부터 %d 사이의 숫자여야 합니다.".formatted(LOTTO_NUMBER_MIN.getValue(), LOTTO_NUMBER_MAX.getValue())),
    LOTTO_MONEY_OUT_OF_RANGE("로또 구입 금액은 %d 이상 %d 이하만 가능합니다.".formatted(LOTTO_MONEY_MIN.getValue(),
            LOTTO_MONEY_MAX.getValue())),
    LOTTO_MONEY_NOT_INTEGER("로또 구입 금액은 정수만 가능합니다."),
    LOTTO_MONEY_UNIT_ERROR("로또 구입 금액은 %d원 단위로 가능합니다.".formatted(LOTTO_MONEY_UNIT.getValue())),
    LOTTO_NUMBER_COUNT_ERROR("로또 번호는 %d개여야 합니다.".formatted(LOTTO_NUMBER_COUNT.getValue())),
    INVALID_INPUT("공백 및 빈 문자열 또는 구분자의 연속 입력은 올바르지 않은 입력입니다.")
    ;

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return EXCEPTION_PREFIX.message + message;
    }
}
