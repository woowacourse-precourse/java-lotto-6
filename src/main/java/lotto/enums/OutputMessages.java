package lotto.enums;

public enum OutputMessages {

    PURCHASE_LOTTO("%d개를 구매했습니다.\n"),
    WINNING_STATISTICS("당첨 통게"),
    DIVIDED_LINE("---"),
    MATCH_NUMBERS("%d개 일치 (%s원) - %d개\n"),
    MATCH_FIVE_NUMBERS_BONUS_NUMBERS("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n"),
    EARNING_RATE("총 수익률은 %.1f%%입니다.");

    private final String message;

    OutputMessages(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
