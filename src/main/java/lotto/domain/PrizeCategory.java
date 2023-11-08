package lotto.domain;

public enum PrizeCategory {
    SIXTH("2개 이하 일치", 0),
    FIFTH("3개 일치", 5000),
    FOURTH("4개 일치", 50000),
    THIRD("5개 일치", 1500000),
    SECOND("5개 일치, 보너스 볼 일치", 30000000),
    FIRST("6개 일치", 2000000000);

    private final String numberOfMatchingNumbers;
    private final long prizeMoney;

    PrizeCategory(String numberOfMatchingNumbers, long prizeMoney) {
        this.numberOfMatchingNumbers = numberOfMatchingNumbers;
        this.prizeMoney = prizeMoney;
    }

    public String getMessage() {
        return String.format("%s (%,d원) - ", numberOfMatchingNumbers, prizeMoney);
    }

    public long getPrizeMoney(){
        long prizeMoney = this.prizeMoney;
        return prizeMoney;
    }
}
