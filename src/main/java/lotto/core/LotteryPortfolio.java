package lotto.core;

import static lotto.core.DrawResult.FIFTH_PRIZE;
import static lotto.core.DrawResult.FIRST_PRIZE;
import static lotto.core.DrawResult.FOURTH_PRIZE;
import static lotto.core.DrawResult.SECOND_PRIZE;
import static lotto.core.DrawResult.THIRD_PRIZE;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class LotteryPortfolio {

    private static int LOTTERY_TICKET_PRICE = 1000;
    private final List<LotteryTicket> holdings;
    private long totalWinnings;

    public LotteryPortfolio() {
        this.totalWinnings = 0;
        this.holdings = new ArrayList<>();
    }

    public void add(LotteryTicket ticket) {
        this.holdings.add(ticket);
    }

    public double profitRate(LotteryTicket winningLotteryTicket, BonusNumber bonusNumber) {
        this.totalWinnings = 0;
        for (LotteryTicket ticket : holdings) {
            totalWinnings += calculateWinnings(ticket, winningLotteryTicket, bonusNumber);
        }
        return roundToOneDecimalPlace((double) totalWinnings / totalSpending() * 100);
    }

    public PortfolioReport analyze(LotteryTicket winningLotteryTicket, BonusNumber bonusNumber) {
        PortfolioReport report = new PortfolioReport();
        for (LotteryTicket lotteryTicket : holdings) {
            if (checkResult(lotteryTicket, winningLotteryTicket, bonusNumber) == FIRST_PRIZE) {
                report.winFirstPlace();
            } else if (checkResult(lotteryTicket, winningLotteryTicket, bonusNumber) == SECOND_PRIZE) {
                report.winSecondPlace();
            } else if (checkResult(lotteryTicket, winningLotteryTicket, bonusNumber) == THIRD_PRIZE) {
                report.winThirdPlace();
            } else if (checkResult(lotteryTicket, winningLotteryTicket, bonusNumber) == FOURTH_PRIZE) {
                report.winFourthPlace();
            } else if (checkResult(lotteryTicket, winningLotteryTicket, bonusNumber) == FIFTH_PRIZE) {
                report.winFifthPlace();
            }
        }
        report.setProfitRate(profitRate(winningLotteryTicket, bonusNumber));
        return report;
    }

    public DrawResult checkResult(LotteryTicket lotteryTicket, LotteryTicket winningLotteryTicket, BonusNumber bonusNumber) {
        return DrawResult.resultOf(lotteryTicket.countHitNumbers(winningLotteryTicket),
                lotteryTicket.containsBonusNumber(bonusNumber));
    }

    public List<LotteryTicket> getHoldings() {
        return holdings;
    }

    public int holdingsAmount() {
        return holdings.size();
    }

    private long calculateWinnings(LotteryTicket ticket, LotteryTicket winningLotteryTicket, BonusNumber bonusNumber) {
        return DrawResult.resultOf(ticket.countHitNumbers(winningLotteryTicket),
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
