package lotto.domain;

public class PurchasedLottery {
    private final Lotto lotto;
    private final LotteryRound round;

    PurchasedLottery(LotteryRound round, Lotto lotto) {
        this.round = round;
        this.lotto = lotto;
    }
}
