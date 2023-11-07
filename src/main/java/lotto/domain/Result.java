package lotto.domain;

public enum Result {
    FIRST("2,000,000,000원", 0),
    SECOND("30,000,000원", 0),
    THIRD("1,500,000원", 0),
    FOURTH("50,000원", 0),
    FIFTH("5,000원", 0);
    private final String price;
    private int count;

    Result(String price, int count) {
        this.price = price;
        this.count = count;
    }

    public void plusCount() {
        this.count++;
    }

    public int getCount() {
        return this.count;
    }

}
