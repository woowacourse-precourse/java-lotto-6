package lotto.view;

import static lotto.core.DrawResult.FIFTH_PRIZE;
import static lotto.core.DrawResult.FIRST_PRIZE;
import static lotto.core.DrawResult.FOURTH_PRIZE;
import static lotto.core.DrawResult.SECOND_PRIZE;
import static lotto.core.DrawResult.THIRD_PRIZE;

import lotto.core.LotteryPortfolio;
import lotto.core.LotteryTicket;
import lotto.core.PortfolioReport;

public class ConsoleView {

    private StringBuilder sb;

    public static ConsoleView reportView(PortfolioReport report) {
        return new ConsoleView(report);
    }

    public static ConsoleView holdingsView(LotteryPortfolio portfolio) {
        return new ConsoleView(portfolio);
    }

    @Override
    public String toString() {
        return sb.toString();
    }

    private ConsoleView(PortfolioReport report) {
        sb = new StringBuilder();
        sb.append(String.format("%d개 일치 (%,d원) - %d개\n",
                FIFTH_PRIZE.getHitCount(), FIFTH_PRIZE.getWinnings(), report.getFifthPlaceCount()));
        sb.append(String.format("%d개 일치 (%,d원) - %d개\n",
                FOURTH_PRIZE.getHitCount(), FOURTH_PRIZE.getWinnings(), report.getFourthPlaceCount()));
        sb.append(String.format("%d개 일치 (%,d원) - %d개\n",
                THIRD_PRIZE.getHitCount(), THIRD_PRIZE.getWinnings(), report.getThirdPlaceCount()));
        sb.append(String.format("%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n",
                SECOND_PRIZE.getHitCount(), SECOND_PRIZE.getWinnings(), report.getSecondPlaceCount()));
        sb.append(String.format("%d개 일치 (%,d원) - %d개\n",
                FIRST_PRIZE.getHitCount(), FIRST_PRIZE.getWinnings(), report.getFirstPlaceCount()));
        sb.append(String.format("총 수익률은 %.1f%%입니다.", report.getProfitRate()));
    }

    private ConsoleView(LotteryPortfolio portfolio) {
        sb = new StringBuilder();
        sb.append(String.format("%d개를 구매했습니다.", portfolio.holdingsAmount()));
        for (LotteryTicket lotteryTicket : portfolio.getHoldings()) {
            sb.append(lotteryTicket + "\n");
        }
    }
}
