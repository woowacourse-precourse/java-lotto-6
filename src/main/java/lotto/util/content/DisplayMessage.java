package lotto.util.content;

public enum DisplayMessage {

    SET_PURCHASE_AMOUNT("구매금액을 입력해 주세요."),
    GET_PURCHASE_AMOUNT("개를 구매했습니다."),
    SET_WIN_NUMBERS("당첨 번호를 입력해 주세요."),
    SET_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    RESULT_TITLE("당첨 통계" + "\n" + "---"),
    NEXT_LINE("\n"),
    RESULT_FORMAT("%s (%s원) - %d개"),
    TOTAL_YIELD("총 수익률은 "),
    POINT_FORMAT("%.1f"),
    END_CONTENT("%입니다.");

    private final String content;

    DisplayMessage(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}
