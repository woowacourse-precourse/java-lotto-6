package lotto.domain.result;

import java.math.BigDecimal;
import java.util.List;
import lotto.domain.number.Lotto;
import lotto.domain.number.Win;
import lotto.io.write.OutputWriter;

public class Result {

    private final Statistics statistics;
    private final WinningMoney winningMoney;
    private final Profit profit;

    public static Result of(Win win, List<Lotto> lottos) {
        return new Result(win, lottos);
    }

    private Result(Win win, List<Lotto> lottos) {
        this.statistics = new Statistics();
        applyLottos(win, lottos);
        this.winningMoney = new WinningMoney(statistics);
        this.profit = new Profit(winningMoney, lottos.size());
    }

    private void applyLottos(Win win, List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            Grade grade = win.match(lotto);
            statistics.apply(grade);
        }
    }

    public void print() {
        OutputWriter.showResult();
        statistics.print();
        profit.print();
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
