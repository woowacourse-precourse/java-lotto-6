package lotto.utility;

import static lotto.utility.IntegerUtil.*;

public enum StringUtil {

    ENTER_PAY_AMOUNT("구입금액을 입력해 주세요."),
    PRINT_LOTTO_COUNT("\n%d개를 구매했습니다.\n"),
    ENTER_WINNING_NUMBER("\n당첨 번호를 입력해 주세요."),
    ENTER_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    PRINT_WINNING_STATISTICS_PHRASES("\n당첨 통계\n---"),
    PRINT_WINNING_DETAILS("%s (%s원) - %d개\n"),
    PRINT_PROFIT("총 수익률은 %.1f%%입니다.\n"),
    PRINT_ERR_PAY_AMOUNT_INVALID_UNIT_INTERVER(String.format("[ERROR] %d원 단위로 떨어지는 금액을 입력해주세요.\n", PAY_AMOUNT_UNIT.getValue())),
    PRINT_ERR_PAY_AMOUNT_NOT_DIGIT("[ERROR] 입력할 금액으로 숫자를 입력해주세요.\n"),
    PRINT_ERR_NUMBER_NOT_DIGIT("[ERROR] 숫자로만 구성된 번호를 입력해주세요.\n"),
    PRINT_ERR_NUMBER_INVALID_RANGE(String.format("[ERROR] %d와 %d사이의 숫자를 입력해주세요.\n",
            LOTTO_NUMBER_START_INCLUSIVE.getValue(),
            LOTTO_NUMBER_END_INCLUSIVE.getValue()
    )),
    PRINT_ERR_WINNING_NUMBER_INVALID_COUNT(String.format("[ERROR] %d개로 구성된 번호들을 입력해주세요.\n", LOTTO_NUMBER_COUNT.getValue())),
    PRINT_ERR_WINNING_NUMBER_DUPLICATE(String.format("중복되지 않은 %d개의 숫자를 입력해주세요.\n", LOTTO_NUMBER_COUNT.getValue()));

    private String message;

    StringUtil(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
