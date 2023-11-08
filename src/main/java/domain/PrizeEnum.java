package domain;

public enum PrizeEnum {
    FIFTH("3", "(5,000원)"),
    FOURTH("4", "(50,000원)"),
    THIRD("5", "(1,500,000원)"),
    SECOND("6", "(30,000,000원)"),
    FIRST("7", "(2,000,000,000원)");


    public String getMatch() {
        return match;
    }

    private final String match;

    public String getPrize() {
        return prize;
    }

    private final String prize;

    PrizeEnum(String match, String prize) {
        this.match = match;
        this.prize = prize;
    }
}
