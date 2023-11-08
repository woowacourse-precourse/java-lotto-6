package lotto.enums;

public enum ErrorMessage {

    NUMBER_FORMAT_ERROR("숫자만 입력해야 합니다."),
    NEGATIVE_NUM_ERROR("구매 금액은 음수로 입력할 수 없습니다."),
    LESS_NUM_ERROR("로또를 구매하기 위해 1000원 이상의 값이 필요합니다."),
    ACCOUNT_UNIT_ERROR("구매 금액은 1000원 단위로 입력해야 합니다."),
    EMPTY_VALUE_ERROR("공백 또는 빈 문자열은 입력할 수 없습니다."),
    INVALID_NUMBERS_COUNT_ERROR("로또 번호는 6개의 숫자로 구성되어야 합니다."),
    EXCEED_LOTTO_RANGE_ERROR("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_NUMBER_ERROR("로또 번호는 중복되지 않는 수여야 합니다."),
    DUPLICATE_WINNING_NUMBER_ERROR("보너스 번호는 당첨 번호와 다른 수여야 합니다.");
    private static final String PREFIX = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }


    public String getMessage() {
        return PREFIX+message;
    }
}
