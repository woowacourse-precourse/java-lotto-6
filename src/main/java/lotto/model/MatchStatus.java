package lotto;

public enum MatchStatus {
    THREE("3개 일치 (5,000원)", 5000),
    FOUR("4개 일치 (50,000원)",50000),
    FIVE("5개 일치 (1,500,000원)", 1500000),
    FIVEANDBONUS("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    SIX("6개 일치 (2,000,000,000원)", 2000000000);

    private String name;
    private long price;

    MatchStatus(String name, long price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }
}
