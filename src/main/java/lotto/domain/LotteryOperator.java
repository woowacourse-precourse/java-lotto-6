package lotto.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LotteryOperator {
    public static final long LOTTO_PRICE = 1000;
    private LotteryRound round;

    private Map<LotteryRound, WinningLottery> history;

    private Collection<? extends LotteryRanking> rankings;

    public LotteryOperator(LotteryRound round, Collection<? extends LotteryRanking> rankings ) {
        this.round = round;
        this.history = new HashMap<>();
        this.rankings = rankings;
    }

    public void draw(List<Integer> winningNumbers, int bonusNumber) {
        history.putIfAbsent(round, WinningLottery.of(winningNumbers, bonusNumber));
        round = round.next();
    }

    public LotteryResults getResult(PurchasedLottery lottery) {
        if (!containsRoundOf(lottery)) {
            return LotteryResults.emptyResults();
        }
        return history.values()
                .stream()
                .map(winningLottery -> winningLottery.getResultFrom(lottery, rankings))
                .findFirst().get();
    }

    private boolean containsRoundOf(PurchasedLottery lottery) {
        return history.keySet().stream()
                .filter(lottery::isEqualRound)
                .count() != 0;
    }

    public LotteryRound currentRound() {
        return round;
    }
}
