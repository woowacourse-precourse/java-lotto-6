package lotto.enums;

public enum LottoPrize {
    THREE_MATCH(5000,"3개 일치 (5,000원) - %d개"),
    FOUR_MATCH(50000,"4개 일치 (50,000원) - %d개"),
    FIVE_MATCH(1500000,"5개 일치 (1,500,000원) - %d개"),
    FIVE_MATCH_BONUS(30000000,"5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    SIX_MATCH(2000000000,"6개 일치 (2,000,000,000원) - %d개"),
    NOT_THING_MATCH(0,"낙첨입니다.");

    private final int prizeAmount;
    private final String message;

    LottoPrize(int prizeAmount, String message) {
        this.prizeAmount = prizeAmount;
        this.message = message;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public String getMessage() {
        return message;
    }
}
