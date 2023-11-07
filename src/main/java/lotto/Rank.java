package lotto;

public enum Rank {
    FIRST("6개 일치 (2,000,000,000원)", 2000000000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    THIRD("5개 일치 (1,500,000원)", 1500000),
    FOURTH("4개 일치 (50,000원)", 50000),
    FIFTH("3개 일치 (5,000원)", 5000),
    NONE("기타", 0)
    ;

    private final String label;
    private final int price;

    Rank(String label, int price) {
        this.label = label;
        this.price = price;
    }

    public String getLabel() {
        return label;
    }

    public int getPrice() {
        return price;
    }
}
