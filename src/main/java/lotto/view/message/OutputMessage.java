package lotto.view.message;

public enum OutputMessage {

    MESSAGE_PURCHASED_COUNT("개를 구매했습니다."),

    // 구매한 복권 출력시 사용
    MESSAGE_PURCHASED_LOTTO_MESSAGE_PREFIX("["),
    MESSAGE_PURCHASED_LOTTO_MESSAGE_SUFFIX("]"),
    MESSAGE_PURCHASED_LOTTO_MESSAGE_Separator(", "),

    // 당첨 통계 출력시 사용
    // 당첨 통계 head section
    MESSAGE_STATISTICS_SECTION_TOP("당첨 통계\n---"),

    // 당첨 통계 body section
    MESSAGE_STATISTICS_FIFTH("3개 일치 (5,000원) - "),
    MESSAGE_STATISTICS_FOURTH("4개 일치 (50,000원) - "),
    MESSAGE_STATISTICS_THIRD("5개 일치 (1,500,000원) - "),
    MESSAGE_STATISTICS_SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    MESSAGE_STATISTICS_FIRST("6개 일치 (2,000,000,000원) - "),
    MESSAGE_STATISTICS_EA("개"),

    // 당첨 통계 footer section
    MESSAGE_STATISTICS_RETURN_PREFIX("총 수익률은 "),
    MESSAGE_STATISTICS_RETURN_SUFFIX("%입니다");

    private final String value;

    OutputMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
