package lotto.utils.constant;

public enum IOConstant {

    GET_LOTTO_MONEY("구입금액을 입력해 주세요."),
    GET_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    GET_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    RESULT("\n당첨 통계\n---\n"),
    STATISTICS("%d개 일치 (%s원) - %d개\n"),
    BONUS_STATISTIC("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n"),
    PROFIT_RATE("총 수익률은 %.1f%%입니다."),
    LOTTO_PREFIX("["),
    LOTTO_POSTFIX("]"),
    INPUT_DELIMITER(","),
    BONUS_MATCH("보너스 볼 일치 "),
    OUTPUT_DELIMITER(", "),
    LOTTO_COUNT("개를 구매했습니다.");

    private String value;

    IOConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
