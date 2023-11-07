package lotto.global.constant;

public enum ConsoleType {

    EMPTY(""),
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    OUTPUT_PURCHASE("%s개를 구매했습니다."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    OUTPUT_STATISTICS("당첨 통계\n---"),
    THREE_MATCH("3개 일치 (5,000원) - %s개"),
    FOUR_MATCH("4개 일치 (50,000원) - %s개"),
    FIVE_MATCH("5개 일치 (1,500,000원) - %s개"),
    FIVE_AND_BONUS_MATCH("5개 일치, 보너스 볼 일치 (30,000,000원) - %s개"),
    ALL_MATCH("6개 일치 (2,000,000,000원) - %s개"),
    OUTPUT_RATE_OF_RETURN("총 수익률은 %s입니다."),
    EXCEPTION("[ERROR] 잘못된 입력입니다. 다시 입력해주세요.");

    private final String comment;

    ConsoleType(final String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public String getComment(Integer input) {
        return String.format(comment, input);
    }

    public String getComment(String input) {
        return String.format(comment, input);
    }
}
