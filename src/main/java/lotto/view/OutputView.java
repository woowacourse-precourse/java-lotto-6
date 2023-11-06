package lotto.view;

import java.util.List;
import lotto.constants.OutputMessages;

public class OutputView {

    public static final String NEWLINE_CHARACTER = "\n";

    public void printNumberOfPurchasedLottoTickets(int numberOfLottoTickets) {
        System.out.print(NEWLINE_CHARACTER);
        System.out.printf(OutputMessages.LOTTO_PURCHASE_MESSAGE.getMessage(), numberOfLottoTickets);
    }

    public void printGeneratedLottos(List<Integer> lotto) {
        System.out.print(lotto + NEWLINE_CHARACTER);
    }

    public void printWinningStatic() {
        System.out.println(OutputMessages.WINNING_STATISTIC_MESSAGE.getMessage());
        System.out.println(OutputMessages.HORIZONTAL_RULE.getMessage());
    }

    public void printMatchPrize() {
        System.out.print(OutputMessages.TOTAL_REVENUE.getMessage());
        System.out.printf(OutputMessages.THREE_MATCH_PRIZE.getMessage(), 0);
        System.out.printf(OutputMessages.FOUR_MATCH_PRIZE.getMessage(), 0);
        System.out.printf(OutputMessages.FIVE_MATCH_PRIZE.getMessage(), 0);
        System.out.printf(OutputMessages.FIVE_BONUS_MATCH_PRIZE.getMessage(), 0);
        System.out.printf(OutputMessages.SIX_MATCH_PRIZE.getMessage(), 0);
    }

    public void printTotalRevenue() {
        System.out.print(OutputMessages.TOTAL_REVENUE.getMessage());
    }

}