package lotto.enums;

public enum OutputMessage {
    PURCHASE_AMOUNT_PROMPT("구입금액을 입력해 주세요."),
    WINNING_NUMBER_PROMPT("\n당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_PROMPT("\n보너스 번호를 입력해 주세요."),
    PURCHASE_NUMBER_OUTPUT("\n%d개를 구매했습니다.\n"),
    WINNING_STATISTICS_OUTPUT("\n당첨 통계\n---");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }


    public String getMessage() {
        return message;
    }
}
