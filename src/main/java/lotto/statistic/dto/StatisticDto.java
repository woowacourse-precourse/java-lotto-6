package lotto.statistic.dto;

import lotto.constant.Prize;

public class StatisticDto {

    private Prize prize;

    public StatisticDto(Prize prize) {
        this.prize = prize;
    }

    public Prize getPrize() {
        return prize;
    }

    public void setPrize(Prize prize) {
        this.prize = prize;
    }
}
