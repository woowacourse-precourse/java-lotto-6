package lotto;

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

    private long calculateWinnings(Lotto ticket, Lotto winningLotto, BonusNumber bonusNumber) {
        return DrawResult.resultOf(ticket.countHitNumbers(winningLotto),
                ticket.containsBonusNumber(bonusNumber)).winnings();
    }

    private int totalSpending() {
        return LOTTERY_TICKET_PRICE * this.holdings.size();
    }

    private double roundToOneDecimalPlace(double number) {
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        return Double.parseDouble(decimalFormat.format(number));
    }
}
