package lotto.constant;

public enum ConsoleMessage {
    ENTER_PURCHASE_AMOUNT("구입금액을 입력해주세요."),
    LOTTO_PURCHASED("%s개를 구매했습니다."),
    DISPLAY_LOTTO_NUMBERS("[%s, %s, %s, %s, %s, %s]"),
    ENTER_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    ENTER_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS_HEADER("당첨 통계"),
    DIVIDER("---"),
    WINNING_STATISTICS_WITHOUT_BONUS_BALL("%s개 일치 (%s원) - %s개"),
    WINNING_STATISTICS_WITH_BONUS_BALL("%s개 일치, 보너스 볼 일치 (%s원) - %s개"),
    TOTAL_RATE_OF_RETURN("총 수익률은 %s입니다.");

    private final String message;

    ConsoleMessage(String message) {
        this.message = message;
    }

    private int getExpectedValueCount() {
        return message.split("%s", -1).length - 1; // Format 할 문자의 개수 반환
    }

    public String getMessage() {
        assert getExpectedValueCount() == 0; // Format 할 문자가 없는 메시지

        return message;
    }

    public String getMessageWithValues(String... values) {
        assert values.length == getExpectedValueCount(); // Format 할 문자가 있는 메시지 (개수 일치 확인)

        return String.format(message, (Object[]) values);
    }
}
