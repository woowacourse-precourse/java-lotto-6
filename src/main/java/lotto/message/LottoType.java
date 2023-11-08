package lotto.message;

public enum LottoType {
    FIVE_THOUSAND(3, "5000"),
    FIFTY_THOUSAND(4, "50000"),
    ONE_HALF_MILLION(5, "1500000"),
    THIRTY_MILLION(5, "30000000"),
    TWO_HUNDRED_MILLION(6, "2000000000"),
    EARNING_RATE(0, "0.0%");

    private int prizeOrdinal;
    private String prizeCost;

    LottoType(int prizeOrdinal, String prizeCost) {
        this.prizeOrdinal = prizeOrdinal;
        this.prizeCost = prizeCost;
    }

    public int getPrizeOrdinal() {
        return prizeOrdinal;
    }

    public String getPrizeCost() {
        return prizeCost;
    }
}
