package lotto.type;

public enum MainMessage {
    MONEY_TO_BUY("구입금액을 입력해 주세요."),
    COUNT_OF_LOTTO("개를 구매했습니다."),
    TYPE_IN_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    TYPE_IN_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    RESULT_OF_LOTTO("당첨 통계" + "\n---"),
    TOTAL_INVESTMENT_RESULT("총 수익률은 "),
    RESULT_IS_PERCENTAGE("%입니다.");

    private final String message;

    MainMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
