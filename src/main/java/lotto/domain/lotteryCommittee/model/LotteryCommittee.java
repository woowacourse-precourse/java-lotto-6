package lotto.domain.lotteryCommittee.model;

import lotto.domain.Lotto;
import lotto.domain.buyer.model.Buyer;

public class LotteryCommittee {

    private Lotto weeklyLottery;

    public Lotto getWeeklyLottery() {
        return weeklyLottery;
    }

    public void setWeeklyLottery(Lotto weeklyLottery) {
        this.weeklyLottery = weeklyLottery;
    }

    public void getWeeklyNumber() {

        //TODO 이번 주 당첨 번호 입력 (6개 + 보너스 1)
    }

    public void announceResult(Buyer buyer) {

        //TODO 결과 발표
    }
}
