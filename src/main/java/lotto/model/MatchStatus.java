package lotto.model;

public enum MatchStatus {
    THREE(3, "3개 일치 (5,000원)", 5000),
    FOUR(4, "4개 일치 (50,000원)",50000),
    FIVE(5, "5개 일치 (1,500,000원)", 1500000),
    FIVEANDBONUS(5, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    SIX(6, "6개 일치 (2,000,000,000원)", 2000000000);

    private int number;
    private String name;
    private long price;

    MatchStatus(int number, String name, long price) {
        this.number = number;
        this.name = name;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }
    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }
}
