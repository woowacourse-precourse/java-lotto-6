package lotto.domain.result;

import java.math.BigDecimal;
import java.util.List;
import lotto.domain.grade.Grade;
import lotto.domain.lotto.Lotto;
import lotto.domain.winning.Winning;

public class Result {

    private final Statistics statistics;
    private final WinningMoney winningMoney;
    private final Profit profit;

    public static Result of() {
        return new Result();
    }

    private Result() {
        this.statistics = Statistics.of();
        this.winningMoney = WinningMoney.of();
        this.profit = Profit.of();
    }

    public void aggregate(Winning winning, List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            Grade grade = winning.match(lotto);
            statistics.apply(grade);
        }
    }

    public void calculate(int lottoSize) {
        this.winningMoney.apply(this.statistics);
        this.profit.apply(this.winningMoney, lottoSize);

    }

    public Statistics getStatistics() {
        return this.statistics;
    }

    public BigDecimal getWinningMoney() {
        return winningMoney.getMoney();
    }

    public Profit getProfit() {
        return this.profit;
    }
}
