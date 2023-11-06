package lotto.global;

public enum ErrorMessage {
    NOT_MET_INPUT_NUMBER("숫자를 입력해주세요."),
    NOT_MET_PURCHASE_UNIT("구매 단위는 1,000 단위에요."),
    NOT_MET_MINIMUM_PURCHASE_AMOUNT("최소 구매 금액은 1,000원이에요."),
    NOT_MET_MAXIMUM_PURCHASE_AMOUNT("구매 금액은 10만원을 넘길 수 없어요."),
    NOT_MET_LOTTO_NUMBERS_RANGE("로또 번호는 1부터 45 숫자만 입력이 가능해요."),
    NOT_MET_WINNING_NUMBER_REGEX("당첨 번호는 숫자와 쉼표(,)로만 입력이 가능해요."),
    NOT_MET_LOTTO_NUMBERS_LENGTH("로또 번호는 중복되지 않은 6개의 숫자만 가능해요."),
    NOT_CONTAINS_BONUS_NUMBER_IN_WINNING_NUMBERS("보너스 숫자는 당첨 번호와 중복 될 수 없어요.");

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private final String message;

    public String getMessage() {
        return ERROR_MESSAGE_PREFIX + message;
    }

    ErrorMessage(String message) {
        this.message = message;
    }
}
