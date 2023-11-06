package lotto;

public enum Prize {
    THREE(5000, "3개 일치 (5,000원)"),
    FOUR(50000, "4개 일치 (50,000원)"),
    FIVE(1500000, "5개 일치 (1,500,000원)"),
    BONUS(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX(2000000000, "6개 일치 (2,000,000,000원)");

    private final int prize;

    private final String information;

    Prize(int prize, String information) {
        this.prize = prize;
        this.information = information;
    }

    public int getPrize() {
        return prize;
    }

}

