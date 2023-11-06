package lotto.domain;

import java.util.List;

public class Profit {
    private Integer amount;

    Profit() {
        this.amount = 0;
    }

    void calculateAmount(List<Rank> ranks) {
        for (Rank rank : ranks) {
            this.amount += rank.getPrizeAmount();
        }
    }

    public Integer getAmount() {
        return amount;
    }
}
