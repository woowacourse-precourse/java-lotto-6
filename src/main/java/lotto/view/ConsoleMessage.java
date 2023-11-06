package lotto.view;

public enum ConsoleMessage {
    
    ENTER_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    ENTER_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    ENTER_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    
    SUCCESS_PURCHASE_LOTTO("%d개를 구매했습니다."),
    RESULTS_SUMMARY("당첨 통계"),
    LOTTO_NUMBER_MATCH("%d개 일치 (%s원) - %d개"),
    LOTTO_NUMBER_MATCH_WITH_BONUS_NUMBER("%d개 일치, 보너스 볼 일치 (%s원) - %d개"),
    TOTAL_RETURN("총 수익률은 %.1f%%입니다.");
    
    private final String message;
    
    ConsoleMessage(final String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
}
