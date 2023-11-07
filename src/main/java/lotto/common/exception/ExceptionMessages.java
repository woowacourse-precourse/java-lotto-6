package lotto.common.exception;

public enum ExceptionMessages {
    INVALID_LOTTO_SIZE("6개의 숫자를 입력해주세요."),
    DUPLICATE_LOTTO_NUMBER("중복된 숫자가 올 수 없습니다."),
    OUT_OF_RANGE_LOTTO_NUMBER("1~45 사이의 숫자를 입력해주세요."),
    DUPLICATE_WINNING_NUMBER("당첨 번호와 보너스 번호에 중복된 숫자가 올 수 없습니다."),
    INVALID_PURCHASE_AMOUNT("구입 금액은 0원일 수 없습니다."),
    NOT_DIVISIBLE_PURCHASE_AMOUNT("구입 금액은 %s원으로 나누어 떨어져야 합니다."),
    INVALID_NUMBER_FORMAT("숫자를 입력해주세요.");

    private static final String MESSAGE_FORMAT = "[ERROR] %s";
    private final String message;

    ExceptionMessages(String message) {
        this.message = String.format(MESSAGE_FORMAT, message);
    }

    public String getMessage() {
        return message;
    }
}
