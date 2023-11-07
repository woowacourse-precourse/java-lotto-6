package lotto.enums;

public enum ErrorMessage {
    NUMBER_FORMAT_ERROR("[ERROR] 숫자만 입력해야 합니다."),
    NEGATIVE_NUM_ERROR("[ERROR] 구매 금액은 음수로 입력할 수 없습니다."),
    LESS_NUM_ERROR("[ERROR] 로또를 구매하기 위해 1000원 이상의 값이 필요합니다."),
    ACCOUNT_UNIT_ERROR("[ERROR] 구매 금액은 1000원 단위로 입력해야 합니다."),
    EMPTY_VALUE_ERROR("[ERROR] 공백 또는 빈 문자열은 입력할 수 없습니다."),
    INVALID_NUMBERS_COUNT_ERROR("[ERROR] 로또 번호는 6개의 숫자로 구성되어야 합니다"),
    EXCEED_LOTTO_RANGE_ERROR("[ERROR] 로또 숫자 범위(1부터 45)를 초과하였습니다"),
    DUPLICATE_NUMBER_ERROR("[ERROR] 중복된 로또 범위가 존재합니다");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }


    public String getMessage() {
        return message;
    }
}
