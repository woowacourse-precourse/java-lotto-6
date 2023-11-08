package lotto.view.constants;

public enum OutputMessage {
    ASK_PURCHASING_AMOUNT("구입금액을 입력해 주세요."),
    COUNT_BUYING_TICKETS("개를 구매했습니다."),
    ASK_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    ASK_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    STATISTICS("""
                
                당첨 통계
                ---
                """),
    PROFIT_START("총 수익률은 "),
    PROFIT_END("%입니다.");
    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
