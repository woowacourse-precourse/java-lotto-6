package lotto.util.message;

public enum Message {
    BUY_MONEY_QUESTION("구입금액을 입력해 주세요."),
    WINNING_NUMBER_QUESTION("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_QUESTION("보너스 번호를 입력해 주세요."),
    THREE_HIT("3개 일치 (5,000원) - "),
    FOUR_HIT("4개 일치 (50,000원) - "),
    FIVE_HIT("5개 일치 (1,500,000원) - "),
    FIVE_WITH_BONUS_HIT("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX_HIT("6개 일치 (2,000,000,000원) - "),
    COUNT("개\n"),
    COMMA(", "),
    OPEN("["),
    BOUGHT("개를 구매했습니다.\n"),
    CLOSE("]\n"),
    RATE("총 수익률은 "),
    PRINT_RATE("입니다.\n"),
    STATISTICS("당첨 통계"),
    PERCENTAGE("%%"),
    LINE("---");
    private final String message;
    private Message(final String message) {
        this.message = message;
    }
    @Override
    public String toString() {
        return message;
    }
}
