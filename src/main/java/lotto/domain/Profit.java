package lotto.domain;

public class Profit {
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
        return profit >= 0;
    }

    public Integer getAmount() {
        return amount;
    }
}
