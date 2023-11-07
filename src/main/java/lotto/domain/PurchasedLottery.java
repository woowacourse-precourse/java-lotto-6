package lotto.domain;

import java.util.List;

public class PurchasedLottery {
    private final Lotto lotto;
    private final LotteryRound round;

    public static PurchasedLottery createLottery(LotteryRound round, LottoRandom random) {
        return new PurchasedLottery(round, Lotto.createLotto(random));
    }

    public PurchasedLottery(LotteryRound round, Lotto lotto) {
        this.round = round;
        this.lotto = lotto;
    }

    public boolean isEqualRound(LotteryRound otherRound) {
        return round.equals(otherRound);
    }

    public List<Integer> getNumbers() {
        return lotto.getNumbers();
    }
}
