package lotto.constant;

public enum ProcessMessage {
    PURCHASE_AMOUNT_REQUSET("구입금액을 입력해 주세요."),
    NUMBER_OF_LOTTO_TICKET("%s개를 구매했습니다."),
    WINNING_LOTTO_REQUEST("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_REQUEST("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계"),
    STATISTICS_DELIMITER("---"),
    NEW_LINE("\n"),
    LEFT_SQUARE_BRACKET("["),
    RIGHT_SQUARE_BRACKET("]"),
    SPACE(" "),
    COMMA("," + SPACE.toMessage());

    private final String message;

    ProcessMessage(final String message) {
        this.message = message;
    }

    public String toMessage() {
        return this.message;
    }
}
