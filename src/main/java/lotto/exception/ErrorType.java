package lotto.exception;

import lotto.util.Constants;

public enum ErrorType {

    PREFIX_MESSAGE("[ERROR] "),
    INPUT_NOT_BLANK("입력은 공백일 수 없습니다. "),
    INPUT_NOT_EMPTY("입력은 비어있을 수 없습니다."),
    INPUT_NOT_NUMERIC("입력은 숫자만 허용합니다."),
    DUPLICATED_BONUS_NUMBER("당첨 번호와 보너스 번호는 중복되지 않습니다."),
    DUPLICATED_LOTTO_NUMBER("로또에 중복된 숫자가 존재합니다."),
    INVALID_LOTTO_SIZE(String.format("로또는 숫자 %d개로 구성됩니다.", Constants.CONFIG_NUMBERS_SIZE)),
    INVALID_IN_RANGE(String.format("로또는 %d~%d 범위 숫자로 구성됩니다.", Constants.MIN_NUMBER_RANGE, Constants.MAX_NUMBER_RANGE)),
    INVALID_DIVIDE_PRICE(String.format("구입 금액은 %d원 단위입니다.", Constants.DIVIDE_PRICE)),
    INVALID_MIN_PRICE(String.format("최소 구입 금액은 %d원 이상입니다.", Constants.MIN_PRICE));

    private final String message;

    ErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX_MESSAGE.message + message;
    }
}
