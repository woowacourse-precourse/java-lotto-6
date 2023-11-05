package lotto.constant;

public enum ConsoleMessage {
    INPUT_BUY_PRICE("구매금액을 입력해 주세요."),
    BUY("%d개를 구매했습니다."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATUS("당첨 통계%n---"),
    RATE_OF_RETURN("총 수익률은 %.1f%%입니다.");

    private final String message;

    ConsoleMessage(String message) {
        this.message = message;
    }

    public void print(Object... args) {
        System.out.printf(message + "%n", args);
    }
}
