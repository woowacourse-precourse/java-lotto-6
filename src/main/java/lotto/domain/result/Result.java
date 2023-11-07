package lotto.domain.result;

import java.math.BigDecimal;
import java.util.List;
import lotto.domain.number.Lotto;
import lotto.domain.number.Winning;
import lotto.service.LottoOutputWriter;

public class Result {

    private final Statistics statistics;
    private final WinningMoney winningMoney;
    private final Profit profit;

    public static Result of(Winning winning, List<Lotto> lottos) {
        return new Result(winning, lottos);
    }

    private Result(Winning winning, List<Lotto> lottos) {
        this.statistics = Statistics.of();
        aggregate(winning, lottos);
        this.winningMoney = WinningMoney.of(statistics);
        this.profit = Profit.of(winningMoney, lottos.size());
    }

    private void aggregate(Winning winning, List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            Grade grade = winning.match(lotto);
            statistics.apply(grade);
        }
    }

    public void print(LottoOutputWriter writer) {
        writer.showResult();
        statistics.print(writer);
        profit.print(writer);
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public BigDecimal getWinningMoney() {
        return winningMoney.getMoney();
    }

    public double getProfit() {
        return profit.getPercentage();
    }
}
