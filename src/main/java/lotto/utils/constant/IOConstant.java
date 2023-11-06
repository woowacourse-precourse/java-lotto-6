package lotto.utils.constant;

public enum IOConstant {

    GET_LOTTO_MONEY("구입금액을 입력해 주세요."),
    GET_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    GET_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    RESULT("당첨 통계\n---"),
    STATISTICS("%d개 일치 (%s원) - %d개"),
    PROFIT_RATE("총 수익률은 %.2f입니다."),
    LOTTO_PREFIX("["),
    LOTTO_POSTFIX("]"),
    INPUT_DELIMITER(","),
    BONUS_MATCH("보너스 볼 일치")
    ;

    private String value;

    IOConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
