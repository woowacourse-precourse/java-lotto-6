package lotto.constants;

public enum Notice {
    ASK_PURCHASE_PRICE("구입금액을 입력해 주세요."),
    PURCHASE_RESULT("개를 구매했습니다."),
    ASK_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    ASK_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_RESULT("당첨 통계\n---"),
    PROFIT_RATE("총 수익률은 %,.1f%%입니다.");
    private final String message;

    Notice(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
