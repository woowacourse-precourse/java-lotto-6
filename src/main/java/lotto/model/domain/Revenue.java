package lotto.model.domain;

public class Revenue {
    private final double revenue;

    public Revenue(long prize, Money money) {
        this.revenue = (100.0 * prize) / money.getMoney();
    }

    public double getRevenue() {
        return revenue;
    }
}
