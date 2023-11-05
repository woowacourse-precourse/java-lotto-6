package lotto.constants;

public enum OutputConstants {

    INPUT_PAYMENT("구입금액을 입력해 주세요."),
    BOUGHT_N("%d개를 구매했습니다."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    THREE_MATCHES("3개 일치 (5,000원) - %d개"),
    FOUR_MATCHES("4개 일치 (50,000원) - %d개"),
    FIVE_MATCHES("5개 일치 (1,500,000원) - %d개"),
    FIVE_MATCHES_AND_BONUS_NOT_MATCHES("5개 일치, 보너스 볼 일치 (30,000,000원) - 0개"),
    SIX_MATCHES("6개 일치 (2,000,000,000원) - %d개"),
    WINNING_STATISTICS("당첨 통계\n---"),
    TOTAL_RATE_OF_RETURN("총 수익률은 %.2f%%입니다.");


    private final String value;

    OutputConstants(String value){
        this.value = value;

    }

    public String getValue(){
        return value;
    }
}
