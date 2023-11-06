package lotto.utility;

public enum StringUtil {

    ENTER_PAY_AMOUNT("구입금액을 입력해 주세요."),
    PRINT_LOTTO_COUNT("\n%d개를 구매했습니다.\n"),
    ENTER_WINNING_NUMBER("\n당첨 번호를 입력해 주세요."),
    ENTER_BONUS_NUMBER("\n보너스 번호를 입력해 주세요.\n"),
    PRINT_WINNING_STATISTICS("당첨 통계\n"),
    PRINT_WINNING_DETAILS("%s (%s원) - %s개\n"),
    PRINT_ROI("총 수익률은 %s%입니다.\n"),
    PRINT_ERR_PAY_AMOUNT_INVALID_UNIT_INTERVER("[ERROR] 1000원 단위로 떨어지는 금액을 입력해주세요.\n"),
    PRINT_ERR_PAY_AMOUNT_NOT_DIGIT("[ERROR] 입력할 금액으로 숫자를 입력해주세요.\n"),
    PRINT_ERR_WINNING_NUMBER_NOT_DIGIT("[ERROR] 숫자로만 구성된 당첨 번호를 입력해주세요.\n");

    private String message;

    StringUtil(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
