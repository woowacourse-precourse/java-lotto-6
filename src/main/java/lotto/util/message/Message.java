package lotto.util.message;

public enum Message {
    THREE_HIT("3개 일치 (5,000원) - "),
    FOUR_HIT("4개 일치 (50,000원) - "),
    FIVE_HIT("5개 일치 (1,500,000원) - "),
    FIVE_WITH_BONUS_HIT("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX_HIT("6개 일치 (2,000,000,000원) - "),
    COUNT("개\n"),
    COMMA(", "),
    OPEN("["),
    BOUGHT("개를 구매했습니다.\n"),
    CLOSE("]\n");
    private final String message;
    private Message(final String message) {
        this.message = message;
    }
    @Override
    public String toString() {
        return message;
    }
}
