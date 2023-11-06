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
        if (profit < 0) {
            throw new IllegalArgumentException();
        }
    }

    public Integer getAmount() {
        return amount;
    }
}
