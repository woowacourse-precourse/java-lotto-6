package lotto.constans;

public enum GameMessage {
    REQUEST_WANT_BUY_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASE_CONFIRMATION("개를 구매했습니다."),
    LOTTO_NUMBER_PREFIX("["),
    LOTTO_NUMBER_SUFFIX("]"),
    LOTTO_NUMBER_SEPARATOR(","),
    REQUEST_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계\n---");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
