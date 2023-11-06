package lotto.domain;

public class LotteryRound {
    private final int round;

    LotteryRound(int round) {
        this.round = round;
    }

    LotteryRound next() {
        return new LotteryRound(round + 1);
    }
}
