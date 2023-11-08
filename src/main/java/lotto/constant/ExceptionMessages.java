package lotto.constant;

public enum ExceptionMessages {

    ERROR_MESSAGE("[ERROR]"),

    PURCHASE_ACCOUNT_TYPE_ERROR_MESSAGE("[ERROR] 로또 구입 금액은 숫자만 입력 가능합니다."),
    PURCHASE_ACCOUNT_RANGE_ERROR_MESSAGE("[ERROR] 로또 구입 금액이 0 이하여서는 안 됩니다."),
    PURCHASE_ACCOUNT_UNIT_ERROR_MESSAGE("[ERROR] 로또 구입 금액은 1000원 단위만 입력 가능합니다."),

    WINNING_NUMBERS_COUNT_ERROR_MESSAGE("[ERROR] 당첨 번호는 6개 입력 가능합니다."),
    DUPLICATED_NUMBER_ERROR_MESSAGE("[ERROR] 입력하신 번호와 중복되는 번호가 존재합니다."),
    NUMBER_TYPE_ERROR_MESSAGE("[ERROR] 번호는 숫자만 입력 가능합니다."),
    NUMBER_RANGE_ERROR_MESSAGE("[ERROR] 번호는 1부터 45 사이의 숫자여야 합니다.");

    private final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
