package lotto.domain;

import java.util.List;

public class PurchasedLottery {
    private final LotteryOperator operator;
    private final Lotto lotto;
    private final LotteryRound round;

    public static PurchasedLottery createLottery(LotteryOperator operator, LottoRandom random) {
        return new PurchasedLottery(operator, operator.currentRound(), Lotto.createLotto(random));
    }

    public PurchasedLottery(LotteryOperator operator, LotteryRound round, Lotto lotto) {
        this.operator = operator;
        this.round = round;
        this.lotto = lotto;
    }

    public boolean isEqualRound(LotteryRound otherRound){
        return round.equals(otherRound);
    }
    public List<Integer> getNumbers() {
        return lotto.getNumbers();
    }
}
