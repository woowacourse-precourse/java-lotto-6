package lotto.statistic.entity;

import lotto.constant.Prize;

import java.util.List;

public class Statistic {

    private Prize prize;

    public Statistic(Prize prize) {
        this.prize = prize;
    }

    public Prize getPrize() {
        return prize;
    }

    public void setPrize(Prize prize) {
        this.prize = prize;
    }
}
