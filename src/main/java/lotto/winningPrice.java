package lotto;

public enum winningPrice {
    THREE("3개 일치 (5,000원)", 5000),
    FOUR("4개 일치 (50,000원)", 50000),
    FIVE("5개 일치 (1,500,000원)", 1500000),
    BONUS("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    SIX("6개 일치 (2,000,000,000원)", 2000000000);

    private final String info;
    private final int price;

    winningPrice(String info, int price) {
        this.info = info;
        this.price = price;
    }

    public String getInfo() {
        return info;
    }

    public int getPrice() {
        return price;
    }
}
