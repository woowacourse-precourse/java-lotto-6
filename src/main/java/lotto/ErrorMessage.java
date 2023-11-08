package lotto;

public enum ErrorMessage {
    LOTTO_NUMBER_RANGE_ERROR("로또 번호는 %d부터 %d 사이의 숫자여야 합니다."),
    LOTTO_LENGTH_ERROR("로또 번호는 중복되지 않은 %d개의 수여야 합니다."),
    MONEY_NEGATIVE_ERROR("금액은 음수가 될 수 없습니다."),
    LOTTO_PURCHASE_ERROR("로또 구매 금액은 %,d원 단위여야 합니다."),
    BONUS_NUMBER_DUPLICATE_ERROR("보너스 번호는 당첨 번호에 포함될 수 없습니다."),
    PURCHASE_MONEY_INPUT_ERROR("구입 금액은 숫자여야 합니다."),
    WINNING_NUMBERS_INPUT_ERROR("당첨 번호는 '%s'로 구분된 숫자여야 합니다."),
    END_WITH_DELIMITER_ERROR("입력은 구분자 '%s'로 끝날 수 없습니다."),
    BONUS_NUMBER_INPUT_ERROR("보너스 번호는 숫자여야 합니다.");

    public static final String HEADER = "[ERROR]";

    private final String message;

    ErrorMessage(String bodyMessage) {
        this.message = String.format("%s %s", HEADER, bodyMessage);
    }

    public String getMessage() {
        return message;
    }
}
