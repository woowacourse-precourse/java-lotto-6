package lotto.enumerate;

public enum Message {
    PLEASE_INPUT_AMOUNT("구입금액을 입력해 주세요."),
    PLEASE_INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    PLEASE_INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    LOTTO_BUYED("%d개를 구매했습니다.\n"),
    PROFIT_RATE_IS("총 수익률은 %.1f%%입니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
