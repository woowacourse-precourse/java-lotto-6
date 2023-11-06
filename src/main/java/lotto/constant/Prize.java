package lotto.constant;

public enum Prize {
    FIFTH("5000"),
    FORTH("50000"),
    THIRD("1500000"),
    SECOND("30000000"),
    FIRST("2000000000");

    private final String prize;

    Prize(String prize) {
        this.prize = prize;
    }

    public String getPrize() {
        return prize;
    }
}
