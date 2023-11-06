package lotto.model.value;

public enum Matching {

    THREE("3개 일치", "5,000원", 5000),
    FOUR("4개 일치", "50,000원", 50000),
    FIVE("5개 일치", "1,500,000원", 1500000),
    FIVE_BONUS("5개 일치, 보너스 볼 일치", "30,000,000원", 30000000),
    SIX("6개 일치", "2,000,000,000원", 2000000000);

    private final String matchingNumber;
    private final String prizeMoney;
    private final int money;

    Matching(String matchingNumber, String prizeMoney, int money) {
        this.matchingNumber = matchingNumber;
        this.prizeMoney = prizeMoney;
        this.money = money;
    }

    public String getMatchingNumber() {
        return matchingNumber;
    }

    public String getPrizeMoney() {
        return prizeMoney;
    }

    public int getMoney() {
        return money;
    }
}
