package lotto.constant.message;

public enum LottoResultMessage {
    THREE_MATCH("3개 일치 (5,000원) - %s개"),
    FOUR_MATCH("4개 일치 (50,000원) - %s개"),
    FIVE_MATCH("5개 일치 (1,500,000원) - %s개"),
    FIVE_MATCH_WITH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - %s개"),
    SIX_MATCH("6개 일치 (2,000,000,000원) - %s개"),
    PROFIT("총 수익률은 %.1f%%입니다.");

    private final String message;

    LottoResultMessage(final String message) {
        this.message = message;
    }

    public String toMessage() {
        return message;
    }

//    public static String getEnum(String input) {
//        return LottoResultMessage.valueOf(input).toMessage();
//    }
}
