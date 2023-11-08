package lotto.domain.result;

public enum Result {
    FIRST(2000000000, "2,000,000,000원", 0),
    SECOND(30000000, "30,000,000원", 0),
    THIRD(1500000, "1,500,000원", 0),
    FOURTH(50000, "50,000원", 0),
    FIFTH(5000, "5,000원", 0);
    private final long long_price;
    private final String str_price;
    private int count;

    Result(long long_price, String str_price, int count) {
        this.long_price = long_price;
        this.str_price = str_price;
        this.count = count;
    }

    public void plusCount() {
        this.count++;
    }

    public int getCount() {
        return this.count;
    }

    public long getRevenue() {
        return this.long_price * this.count;
    }

}
