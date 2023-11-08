package lotto.exception;

public enum ErrorCode {
    LOTTO_NUMBERS_INVALID_SIZE("로또 번호는 6개여야 합니다."),
    LOTTO_NUMBERS_DUPLICATED("로또 번호는 중복될 수 없습니다."),
    LOTTO_NUMBERS_OUT_OF_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    BONUS_NUMBER_OUT_OF_RANGE("보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    BONUS_NUMBER_DUPLICATED("보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    PURCHASE_AMOUNT_INVALID_VALUE("구입금액은 1000원 단위여아 합니다."),
    PURCHASE_AMOUNT_OUT_OF_RANGE("구입금액은 양수여야 합니다."),
    INPUT_NON_INT_PURCHASE_AMOUNT("구입금액은 정수로 입력해야 합니다."),
    INPUT_NON_INT_MAIN_WINNING_NUMBERS("당첨 번호는 쉼표로 구분된 정수들로 입력해야 합니다."),
    INPUT_NON_INT_BONUS_NUMBER("보너스 번호는 정수로 입력해야 합니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getFormattedMessage() {
        return "[ERROR] " + message;
    }
}
