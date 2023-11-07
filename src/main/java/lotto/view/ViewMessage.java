package lotto.view;

public enum ViewMessage {

    INPUT_MONEY_PRINT("구입금액을 입력해 주세요."),
    OUTPUT_BUY_TICKET_PRINT("개를 구매했습니다."),
    INPUT_WINNER_NUMBERS_PRINT("\n당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER_PRINT("\n보너스 번호를 입력해 주세요."),
    OUTPUT_WINNING_STATISTICS_PRINT("\n당첨 통계\n---"),
    OUTPUT_REVENUE_PREFIX_PRINT("총 수익률은 "),
    OUTPUT_REVENUE_POSTFIX_PRINT("%입니다.");



    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
