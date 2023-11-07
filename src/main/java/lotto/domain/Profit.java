package lotto.domain;

import lotto.dto.Ranks;

public class Profit {
    private Integer amount;

    public Profit() {
        this.amount = 0;
    }

    public void calculateAmount(Ranks ranks) {
        for (Rank rank : ranks.getRanks()) {
            this.amount += rank.getPrizeAmount();
        }
    }

    public Integer getAmount() {
        return amount;
    }
}
