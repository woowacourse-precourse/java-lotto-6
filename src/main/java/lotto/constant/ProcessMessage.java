package lotto.constant;

public enum ProcessMessage {
    PURCHASE_AMOUNT_REQUSET("구입금액을 입력해 주세요."),
    NUMBER_OF_LOTTO_TICKET("%s개를 구매했습니다."),
    WINNING_LOTTO_REQUEST("당첨 번호를 입력해주세요"),
    NEW_LINE("\n"),
    LEFT_SQUARE_BRACKET("["),
    RIGHT_SQUARE_BRACKET("]"),
    SPACE(" "),
    COMMA("," + SPACE.toValue());

    private final String message;

    ProcessMessage(String message) {
        this.message = message;
    }

    public String toValue() {
        return this.message;
    }
}
