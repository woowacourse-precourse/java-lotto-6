package lotto.config.output;

public enum MessageType {
    INPUT_BUY_START("구입금액을 입력해 주세요. \n"),
    INPUT_BUY_END("\n%d개를 구매했습니다.\n"),

    INPUT_START_WIN_NUMBER("\n당첨 번호를 입력해 주세요.\n"),
    INPUT_START_BONUS("\n보너스 번호를 입력해 주세요.\n"),

    INPUT_BUYER_FORMAT("%s\n"),
    INPUT_ERROR("%s"),

    OUTPUT_MATCH_STATICS("\n담청 통계\n---\n"),
    MATCH_3_COUNT("3개 일치 (5,000원) - %d개\n"),
    MATCH_4_COUNT("4개 일치 (50,000원) - %d개\n"),
    MATCH_5_COUNT("5개 일치 (1,500,000원) - %d개\n"),
    MATCH_6_COUNT("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    MATCH_7_COUNT("6개 일치 (2,000,000,000원) - %d개\n"),
    OUTPUT_RETURNS("총 수익률은 %s입니다.")
    ;

    private final String value;

    MessageType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
