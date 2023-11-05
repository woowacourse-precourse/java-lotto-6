package lotto.code;

/**
 * Message
 * <pre>
 * Describe here
 * </pre>
 *
 * @version 1.0,
 */
public enum GameMessage {
    INPUT_AMOUNT("구입금액을 입력해 주세요."),
    LOTTO_COUNT("개를 구매했습니다."),
    ;

    private GameMessage(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }
}
