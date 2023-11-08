package lotto.constant;

public enum PrintMessage {
    PAYMENT_REQUEST("구입금액을 입력해 주세요."),
    WINNING_NUMBER_REQUEST("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_REQUEST("보너스 번호를 입력해 주세요."),
    AMOUT_LOTTO("개를 구매했습니다."),
    PRINT_PROFIT_RATE("총 수익률은 %s%%입니다.");

    private String message;

    private PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
