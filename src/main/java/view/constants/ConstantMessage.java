package view.constants;

public enum ConstantMessage {
    PURCHASE_PRICE_INPUT("구입금액을 입력해 주세요."),
    PURCHASE_NUMBER_OUTPUT("개를 구매했습니다."),
    WINNING_NUMBER_INPUT("당첨 번호를 입력해 주세요."),
    BONUS_INPUT("보너스 번호를 입력해 주세요."),
    WINNING_RESULT_TITLE("당첨 통계"),
    WINNING_RESULT_UNDERSCORE("---"),
    WINNING_RESULT_THREE("3개 일치 (5,000원) - "),
    WINNING_RESULT_FOUR("4개 일치 (50,000원) - "),
    WINNING_RESULT_FIVE("5개 일치 (1,500,000원) - "),
    WINNING_RESULT_FIVE_AND_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    WINNING_RESULT_SIX("6개 일치 (2,000,000,000원) - "),
    NUMBER_UNIT("개"),
    TOTAL_BENEFIT_FIRST("총 수익률은 "),
    TOTAL_BENEFIT_LAST("%입니다.");


    private final String message;

    ConstantMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
