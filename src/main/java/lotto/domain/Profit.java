package lotto.domain;

import java.util.List;

public class Profit {
    private Integer amount;

    public Profit() {
        this.amount = 0;
    }

    public void calculateAmount(List<Rank> ranks) {
        for (Rank rank : ranks) {
            this.amount += rank.getPrizeAmount();
        }
    }

    public Integer getAmount() {
        return amount;
    }
}
