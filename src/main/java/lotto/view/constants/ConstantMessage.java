package lotto.view.constants;

public enum ConstantMessage {
    ENTERING_PURCHASE_AMOUNT("구입 금액을 입력해 주세요.\n"),
    GUIDANCE_FOR_PURCHASE_QUANTITY("%d개를 구매했습니다.\n"),
    ENTERING_WINNING_NUMBER("당첨 번호를 입력해주세요.\n"),
    ENTERING_BONUS_NUMBER("보너스 번호를 입력해주세요.\n"),
    WINNING_STATISTICS_NOTICE("당첨 통계\n"),
    DIVIDER("---\n"),
    LOTTO_RESULT("%d개 일치 (%d원) - %d개\n"),

    LOTTO_RESULT_WITH_BONUS("%d개 일치, 보너스 볼 일치 (%d원) - %d개\n"),

    TOTAL_RETURN_RATE("총 수익률은 %.1f%입니다.\n");

    private final String message;

    ConstantMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
