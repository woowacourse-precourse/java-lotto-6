package lotto.domain;

public class Profit {
    private static final int MINIMUM_PROFIT = 0;
    private Integer amount;

    Profit() {
        this.amount = 0;
    }

    void add(Integer profit) {
        validate(profit);
        this.amount += profit;
    }

    private void validate(Integer profit) {
        if (isNotPositiveProfit(profit)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNotPositiveProfit(Integer profit) {
        return profit < MINIMUM_PROFIT;
    }

    public Integer getAmount() {
        return amount;
    }
}
