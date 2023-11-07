package lotto.constants;

import static lotto.constants.Constants.Integers.LOTTO_SIZE;

public enum ErrorMessage implements Message {

    CANNOT_READ_EMPTY_INPUT("빈 값을 입력해선 안됩니다."),
    INVALID_NUMBER_FORMAT("올바른 형태가 아닙니다."),
    HAVE_TO_INPUT_MULTIPLE_OF_LOTTO_PRICE("로또 1장 가격의 배수를 입력해야합니다."),
    HAVE_TO_INPUT_MORE_THAN_LOTTO_PRICE("최소 1장 이상 구매할 수 있는 금액을 입력해야합니다."),
    LOTTO_NUMBER_NOT_IN_RANGE("로또 번호의 범위를 벗어났습니다."),
    WRONG_LOTTO_SIZE(String.format("로또 번호는 %d개가 필요합니다.", LOTTO_SIZE.getValue())),
    DUPLICATED_NUMBER_EXIST("중복되는 로또 번호가 존재합니다."),
    HAVE_TO_INPUT_ONLY_NUMBER_AND_DELIMITER("공백없이 숫자와 구분자만 입력해야합니다.")
    ;

    private static final String PREFIX = "[ERROR] ";

    private static final String SUFFIX = " 다시 입력해 주세요.";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return PREFIX + this.message + SUFFIX;
    }
}
