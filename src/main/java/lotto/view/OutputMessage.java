package lotto.view;

public enum OutputMessage {
    REQUEST_LOTTO_COST("구입금액을 입력해 주세요."),
    RESPONSE_PURCHASED_LOTTO_AMOUNT("개를 구매했습니다."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    REQUEST_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    WINNING_DETAILS_TITLE("당첨 통계\n---"),
    RESPONSE_EARNINGS_RATE("총 수익률은 %s%%입니다."),
    LINE_BREAKING("\n");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
