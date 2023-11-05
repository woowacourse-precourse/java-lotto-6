package lotto;

public enum OutputMessage {
    REQUEST_MONEY_TO_BUY("구입금액을 입력해 주세요."),
    BUY_LOTTO_RESULT("%d개를 구매했습니다."),
    REQUEST_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public final String getMessage() {
        return message;
    }
}
