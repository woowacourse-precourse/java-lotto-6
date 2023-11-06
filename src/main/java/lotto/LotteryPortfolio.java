package lotto;

import static lotto.DrawResult.FIFTH_PRIZE;
import static lotto.DrawResult.FIRST_PRIZE;
import static lotto.DrawResult.FOURTH_PRIZE;
import static lotto.DrawResult.SECOND_PRIZE;
import static lotto.DrawResult.THIRD_PRIZE;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class LotteryPortfolio {

    private static int LOTTERY_TICKET_PRICE = 1000;
    private final List<Lotto> holdings;
    private long totalWinnings;

    public LotteryPortfolio() {
        this.totalWinnings = 0;
        this.holdings = new ArrayList<>();
    }

    public void add(Lotto ticket) {
        this.holdings.add(ticket);
    }

    public double profitRate(Lotto winningLotto, BonusNumber bonusNumber) {
        this.totalWinnings = 0;
        for (Lotto ticket : holdings) {
            totalWinnings += calculateWinnings(ticket, winningLotto, bonusNumber);
        }
        return roundToOneDecimalPlace((double) totalWinnings / totalSpending() * 100);
    }

    public PortfolioReport analyze(Lotto winningLotto, BonusNumber bonusNumber) {
        PortfolioReport report = new PortfolioReport();
        for (Lotto lotto : holdings) {
            if (checkResult(lotto, winningLotto, bonusNumber) == FIRST_PRIZE) {
                report.winFirstPlace();
            } else if (checkResult(lotto, winningLotto, bonusNumber) == SECOND_PRIZE) {
                report.winSecondPlace();
            } else if (checkResult(lotto, winningLotto, bonusNumber) == THIRD_PRIZE) {
                report.winThirdPlace();
            } else if (checkResult(lotto, winningLotto, bonusNumber) == FOURTH_PRIZE) {
                report.winFourthPlace();
            } else if (checkResult(lotto, winningLotto, bonusNumber) == FIFTH_PRIZE) {
                report.winFifthPlace();
            }
        }
        report.setProfitRate(profitRate(winningLotto, bonusNumber));
        return report;
    }

    public DrawResult checkResult(Lotto lotto, Lotto winningLotto, BonusNumber bonusNumber) {
        return DrawResult.resultOf(lotto.countHitNumbers(winningLotto),
                lotto.containsBonusNumber(bonusNumber));
    }

    public List<Lotto> getHoldings() {
        return holdings;
    }

    private long calculateWinnings(Lotto ticket, Lotto winningLotto, BonusNumber bonusNumber) {
        return DrawResult.resultOf(ticket.countHitNumbers(winningLotto),
                ticket.containsBonusNumber(bonusNumber)).getWinnings();
    }

    private int totalSpending() {
        return LOTTERY_TICKET_PRICE * this.holdings.size();
    }

    private double roundToOneDecimalPlace(double number) {
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        return Double.parseDouble(decimalFormat.format(number));
    }
}
