package lotto.constants;

public enum MessageConstants {
    ASK_COST_ENTER("구입금액을 입력해 주세요."),
    LOTTO_PURCHASE("개를 구매했습니다."),
    ASK_WINNING_NUMBER_ENTER("\n당첨 번호를 입력해 주세요."),
    ASK_BONUS_NUMBER_ENTER("\n보너스 번호를 입력해 주세요."),
    RESULT_OVERVIEW("\n당첨 통계\n---"),
    PROFIT_MESSAGE("총 수익률은 %.1f%%입니다.");

    private final String message;

    MessageConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
