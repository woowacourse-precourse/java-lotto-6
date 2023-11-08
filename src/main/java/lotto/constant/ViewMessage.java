package lotto.constant;

public enum ViewMessage {
    AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    WINNING_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    BUY_MESSAGE("%d개를 구매했습니다."),
    RATE_OF_RETURN_MESSAGE("총 수익률은 %,.1f%%입니다."),
    STATISTICS_RESULT_MESSAGE("당첨 통계\n---\n")
    ;

    private final String message;


    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
