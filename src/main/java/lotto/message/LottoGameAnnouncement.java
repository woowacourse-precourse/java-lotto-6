package lotto.message;

public enum LottoGameAnnouncement {
    ASK_PURCHASE_MONEY("구입금액을 입력해 주세요."),
    COUNT_OF_LOTTO("개를 구매했습니다."),
    ASK_WIN_NUMBERS("당첨 번호를 입력해 주세요."),
    ASK_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    ANNOUNCE_BEFORE_RESULT("당첨 통계"),
    SECTION("---"),
    ;

    private final String message;

    LottoGameAnnouncement(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public static String getProfitPercentageMessage(double profit) {
        return "총 수익률은 " + profit + "%입니다.";
    }
}
