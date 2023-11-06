package lotto.enums;

public enum ExceptionMessage {
    AMOUNT_UNIT_ERROR("1,000원 단위로 입력해주세요."),
    NON_NUMERIC_VALUE_ERROR("숫자가 아닌 값이 포함되어 있습니다."),
    NUMBER_RANGE_ERROR("숫자는 %d에서 %d 사이어야 합니다."),
    DUPLICATE_NUMBER_ERROR("중복된 숫자가 있습니다."),
    NUMBER_COUNT_ERROR("로또 번호는 %d개여야 합니다."),
    BONUS_NUMBER_DUPLICATE_ERROR("보너스 번호에 중복이 있습니다.");

    private static final String PREFIX = "[ERROR] ";
    public final String message;

    ExceptionMessage(String message) {
        this.message = PREFIX + message;
    }
}
