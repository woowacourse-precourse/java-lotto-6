package lotto.domain;

import java.util.List;

public class PurchasedLottery {
    private final Lotto lotto;
    private final LotteryRound round;

    public static PurchasedLottery createLottery(LottoRandom random){
        return new PurchasedLottery(LottoOperator.currentRound, Lotto.createLotto(random));
    }
    public PurchasedLottery(LotteryRound round, Lotto lotto) {
        this.round = round;
        this.lotto = lotto;
    }

    public List<Integer> getNumbers() {
        return lotto.getNumbers();
    }
}
