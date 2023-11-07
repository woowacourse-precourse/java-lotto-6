package lotto.message;

public enum LottoMessage {
    PURCHASE_PRICE("구입금액을 입력해 주세요."),
    PURCHASE_COUNT("개를 구매했습니다."),
    WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_RESULT("당첨 통계"),
    THREE_MATCH("3개 일치 (5000원) - "),
    FOUR_MATCH("4개 일치 (50000원) - "),
    FIVE_MATCH("5개 일치 (1500000원) - "),
    FIVE_MATCH_WITH_BONUS("5개 일치, 보너스 볼 일치 (30000000원) - "),
    SIX_MATCH("6개 일치 (2000000000원) - "),
    QUANTITY("개"),
    PROFIT_RATE("총 수익률은 "),
    PERCENT("%입니다.");

    private final String message;

    LottoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
