package lotto.view;

public enum ClientMessage {
    ASK_BUY_PRICE("구입금액을 입력해 주세요."),
    AFTER_BUY("%d개를 구매했습니다."),
    ASK_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    ASK_BONUS_NUMBERS("보너스 번호를 입력해주세요"),
    WINNING_RESULT("당첨 통계"),
    SEPARATOR("---"),
    LOTTO_RESULT("%s - %d개"),
    TOTAL_PROFIT("총 수익률은 %.1f%%입니다."),
    ERROR("[ERROR] %s");

    private String message;

    ClientMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
