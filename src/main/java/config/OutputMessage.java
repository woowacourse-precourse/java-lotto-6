package config;

public enum OutputMessage {

    DEPOSIT("구입금액을 입력해 주세요."),
    PAYMENT("\n%d개를 구매했습니다.\n"),
    WIN_NUMBER("\n당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    RESULT("\n당첨 통계\n---"),
    RATE("총 수익률은 %.1f%%입니다.");

    private final String message;

    private OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
