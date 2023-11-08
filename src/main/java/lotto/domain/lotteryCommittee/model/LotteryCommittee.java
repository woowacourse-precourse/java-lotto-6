package lotto.domain.lotteryCommittee.model;

import lotto.domain.lotto.model.Lotto;
import lotto.domain.buyer.model.Buyer;

public class LotteryCommittee {

    private Lotto weeklyLottery;
    private int bonusNum;

    public Lotto getWeeklyLottery() {
        return weeklyLottery;
    }

    public void setWeeklyLottery(Lotto weeklyLottery) {
        this.weeklyLottery = weeklyLottery;
    }

    public int getBonusNum() {
        return bonusNum;
    }

    public void setBonusNum(int bonusNum) {
        this.bonusNum = bonusNum;
    }
}
