package Constant;

public enum ViewMessage {
    PRINT_PURCHASE_RESULT("%d개를 구매했습니다.\n"),
    PRINT_WINNING_STATISTICS("당첨 통계\n---\n"),
    PRINT_RATE_OF_RETURN("총 수익률은 %s%%입니다."),
    ASK_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    ASK_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    ASK_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
