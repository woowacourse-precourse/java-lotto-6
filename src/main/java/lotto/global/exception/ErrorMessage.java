package lotto.global.exception;

import static lotto.global.constants.NumberType.COST_UNIT;
import static lotto.global.constants.NumberType.LOTTO_SIZE;

public enum ErrorMessage {
    BLANK_INPUT_ERROR("빈 문자열이 입력되었습니다."),
    NOT_NUMBER_ERROR("숫자를 입력해주세요."),
    INVALID_UNIT_ERROR(String.format("%d원 단위의 구입 금액을 입력해주세요.", COST_UNIT.getValue())),
    INVALID_SEPARATOR_ERROR("올바르지 않은 구분자 입력입니다."),
    INVALID_RANGE_ERROR("올바르지 않은 범위의 입력입니다."),
    DUPLICATED_NUMBER_ERROR("중복되지 않은 숫자를 입력해주세요."),
    INVALID_LOTTO_SIZE_ERROR(String.format("%d개의 로또 번호를 입력해주세요.", LOTTO_SIZE.getValue()));

    private static final String PREFIX = "[ERROR]";
    private final String message;

    ErrorMessage(String message) {
        this.message = PREFIX + message;
    }

    public String getMessage() {
        return this.message;
    }
}
