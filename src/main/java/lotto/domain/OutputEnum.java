package lotto.domain;

public enum OutputEnum {

    LOTTO_AMOUNT("구입금액을 입력해 주세요."),
    WINNING_NUM("\n당첨 번호를 입력해 주세요."),
    BONUS_NUM("\n보너스 번호를 입력해 주세요."),
    LOTTO_COUNT("\n%s개를 구매했습니다.\n"),
    WINNING_STATISTICS("\n당첨 통계 \n---"),
    MATCH_COUNT_FREQUENCY("%d개 일치 (%s원) - %d개\n"),
    MATCH_COUNT_FREQUENCY_2ND("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n"),
    RETURN_RATE("총 수익률은 %.1f%%입니다.");

    private final String output;

    private OutputEnum(String output) {
        this.output = output;
    }

    public String getOutput() {
        return output;
    }
}
