package lotto.error;

public enum ErrorMessage {

    INVALID_LOTTO_SIZE("로또 번호는 6개여야 합니다."),
    INVALID_LOTTO_INPUT("로또 번호는 중복되면 안됩니다."),
    INVALID_PURCHASE_AMOUNT("구입 금액은 1,000원 단위여야 합니다."),
    INPUT_NOT_DIGIT("입력값은 숫자여야 합니다."),
    BONUS_NUMBER_DUPLICATE("당첨 번호 중에 보너스 번호와 중복되는 번호가 있습니다."),
    LOTTO_NUMBER_DUPLICATE("당첨 번호 중에 중복되는 번호가 있습니다.");

    private String message;
    private static final String PREFIX = "[ERROR] ";

    ErrorMessage(String message) {
        this.message = PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
