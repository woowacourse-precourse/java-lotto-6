package lotto.Model;

public enum Prize {
    SIX(2000000000.0, 0),
    FIVE_BONUS(30000000.0, 0),
    FIVE(1500000.0, 0),
    FOUR(50000.0, 0),
    THREE(5000.0, 0),
    NONE(0.0, 0);

    private final Double price;
    private Integer count;

    private Prize(Double price, Integer count) {
        this.price = price;
        this.count = count;
    }

    public Double getPrice() {
        return this.price;
    }

    public Integer getCount() {
        return this.count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}
