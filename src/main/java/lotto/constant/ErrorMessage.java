package lotto.constant;

public enum ErrorMessage {
    NULL_INPUT_ERROR("[ERROR] 입력값이 비어있습니다."),
    NON_NUMERIC_ERROR("[ERROR] 숫자만 입력해주세요."),
    INTEGER_FORMAT_ERROR("[ERROR] 정수만 입력해주세요."),
    NUMBER_RANGE_ERROR("[ERROR] 유효한 범위의 숫자만 입력해주세요."),
    MONEY_UNIT_ERROR("[ERROR] " + LottoInformation.MONEY_UNIT.getNumber() + "원 단위로 입력해주세요."),
    LOTTO_SIZE_ERROR("[ERROR] 6개의 번호를 입력해주세요."),
    LOTTO_NUMBER_RANGE_ERROR("[ERROR] 1에서 45 사이의 숫자로 입력해주세요."),
    DUPLICATE_LOTTO_NUMBER_ERROR("[ERROR] 중복된 숫자는 허용되지 않습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
