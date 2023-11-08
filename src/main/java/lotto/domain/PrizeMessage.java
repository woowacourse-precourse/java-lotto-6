package lotto.domain;

enum PrizeMessage {
    ZERO(0, ""),
    ONE(1, ""),
    TWO(2, ""),
    THREE(3, "3개 일치 (5,000원) - %d개\n"),
    FOUR(4, "4개 일치 (50,000원) - %d개\n"),
    FIVE(5, "5개 일치 (1,500,000원) - %d개\n"),
    SIX(6, "6개 일치 (2,000,000,000원) - %d개\n"),
    FIVE_BONUS(7, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n");

    private final String message;

    PrizeMessage(Integer number, String message) {
        this.message = message;
    }

    public static PrizeMessage getByOrdinal(int ordinal) {
        for (PrizeMessage prize : values()) {
            if (prize.ordinal() == ordinal) {
                return prize;
            }
        }
        throw new IllegalArgumentException("[ERROR]" + ordinal);
    }

    public String getMessage() {
        return message;
    }
}
