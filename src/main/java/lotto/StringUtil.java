package lotto;

public enum StringUtil {

    ENTER_PAY_AMOUNT("구입금액을 입력해 주세요."),
    PRINT_LOTTO_COUNT("%d개를 구매했습니다.\n"),
    ENTER_WINNING_NUMBER("당첨 번호를 입력해 주세요.\n"),
    ENTER_BONUS_NUMBER("보너스 번호를 입력해 주세요.\n"),
    PRINT_WINNING_STATISTICS("당첨 통계\n"),
    PRINT_WINNING_DETAILS("%s (%s원) - %s개\n"),
    PRINT_ROI("총 수익률은 %s%입니다.\n"),
    PRINT_ERR_PAY_AMONUT("[ERROR] 1000원 단위로 떨어지는 금액을 입력해주세요.\n");

    private String message;

    StringUtil(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
