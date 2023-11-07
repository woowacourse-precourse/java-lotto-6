package lotto.constant;

public enum Error {

    IS_BRANK("공백은 입력할 수 없습니다"),
    ABLE_NUMBER("숫자만 입력 가능합니다"),
    DUPLICATED_NUMBER("중복된 숫자가 입력되었습니다."),
    DUPLICATED_BONUS_NUMBER("당첨 번호에 해당하지 않는 보너스 번호를 입력해야 합니다"),
    MINIMUM_PAYMENT("구입 비용은 1,000원 이상이어야 합니다"),
    INVALID_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ONLY_VALUE_THOUSAND("1,000원 단위로만 입력 가늘합니다."),
    INVALID_NUMBER_COUNT("6개의 숫자를 입력해야 합니다.");

    private static final String ERROR_ANNOUNCER = "[ERROR] ";
    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_ANNOUNCER + message;
    }
}
