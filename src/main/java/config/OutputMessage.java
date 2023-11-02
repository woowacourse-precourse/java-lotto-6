package config;

public enum OutputMessage {

    DEPOSIT("구입금액을 입력해 주세요."),
    PAYMENT("개를 구매했습니다."),
    WIN_NUMBER("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    RESULT("당첨 통계\n---"),
    FIFTH("3개 일치 (5,000원) - %d개"),
    FOURTH("4개 일치 (50,000원) - %d개"),
    THIRD("5개 일치 (1,500,000원) - %d개"),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST("6개 일치 (2,000,000,000원) - %d개"),
    RATE("총 수익률은 %.1f%%입니다.");

    private String message;

    private OutputMessage(String message) { this.message = message; }

    public String getMessage() { return message; }
}
