package lotto.domain;

public class LotteryRound {
    private final int round;

    public LotteryRound(int round) {
        this.round = round;
    }

    LotteryRound next() {
        return new LotteryRound(round + 1);
    }
}
