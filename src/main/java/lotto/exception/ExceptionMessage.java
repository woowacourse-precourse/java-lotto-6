package lotto.exception;

public enum ExceptionMessage {
    LOTTO_WRONG_NUMBERS_COUNT("로또 번호의 개수가 6이어야 합니다."),
    LOTTO_DUPLICATE_NUMBERS("중복된 번호가 있습니다."),
    LOTTO_WRONG_PURCHASE_AMOUNT("로또 1장의 가격은 1,000원입니다. 1,000원단위로 입력해 주세요."),
    LOTTO_WRONG_WINNING_NUMBERS_COUNT("당첨 번호를 6개 입력해 주세요."),
    LOTTO_WRONG_NUMBER_RANGE("로또 번호의 숫자 범위는 1부터 45까지입니다."),
    PURCHASE_AMOUNT_IS_NOT_DIGIT("구입금액은 숫자로 입력해 주세요."),
    WINNING_NUMBER_IS_NOT_DIGIT("당첨 번호를 숫자로 입력해 주세요."),
    BONUS_NUMBER_IS_NOT_DIGIT("보너스 번호를 숫자로 입력해 주세요.");

    private static final String TAG_ERROR = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = TAG_ERROR + message;
    }

    public void throwIllegalArgumentException() {
        throw new IllegalArgumentException(message);
    }
}
