package lotto.domain;

import java.util.List;
import java.util.Objects;

public class PurchasedLottery {
    private final Lotto lotto;
    private final LotteryRound round;

    public static PurchasedLottery createLottery(LotteryRound round, LottoRandom random) {
        return new PurchasedLottery(round, Lotto.createLotto(random));
    }

    public PurchasedLottery(LotteryRound round, Lotto lotto) {
        this.round = Objects.requireNonNull(round);
        this.lotto = Objects.requireNonNull(lotto);
    }

    public boolean isEqualRound(LotteryRound otherRound) {
        return round.equals(otherRound);
    }

    public List<Integer> getNumbers() {
        return lotto.getNumbers();
    }
}
