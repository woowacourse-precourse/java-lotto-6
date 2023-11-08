package lotto;

public enum Prize {
    FIFTH(5000, "3개 일치 (5,000원) - %d개\n"),
    FOURTH(50000, "4개 일치 (50,000원) - %d개\n"),
    THIRD(1500000, "5개 일치 (1,500,000원) - %d개\n"),
    SECOND(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    FIRST(2000000000, "6개 일치 (2,000,000,000원) - %d개\n");

    private final int prizeMoney;
    private final String message;

    Prize(int prizeMoney, String message) {
        this.prizeMoney = prizeMoney;
        this.message = message;
    }

    public int value() {
        return prizeMoney;
    }

    @Override
    public String toString() {
        return message;
    }
}
