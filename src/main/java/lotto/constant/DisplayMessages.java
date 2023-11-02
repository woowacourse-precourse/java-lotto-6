package lotto.constant;

public enum DisplayMessages {
    LOTTO_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASE_QUANTITY("%s개를 구매했습니다."),
    REQUEST_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    MATCH_COUNT("%s개 일치 (%s원) - %s개"),
    MATCH_COUNT_BONUS("%s개 일치, 보너스 볼 일치 (%s원) - %s개"),
    TOTAL_RETURN("총 수익률은 %s%%입니다.")
    ;

    private final String message;

    DisplayMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public String format(String... args) {
        return String.format(message, (Object[]) args);
    }
}
