package lotto.view;

import java.util.List;
import lotto.constants.OutputMessages;
import lotto.domain.LottoResult;

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

    public void printMatchPrize(LottoResult lottoResult) {
        System.out.printf(OutputMessages.THREE_MATCH_PRIZE.getMessage(), lottoResult.getCount(5));
        System.out.printf(OutputMessages.FOUR_MATCH_PRIZE.getMessage(), lottoResult.getCount(4));
        System.out.printf(OutputMessages.FIVE_MATCH_PRIZE.getMessage(), lottoResult.getCount(3));
        System.out.printf(OutputMessages.FIVE_BONUS_MATCH_PRIZE.getMessage(),
            lottoResult.getCount(2));
        System.out.printf(OutputMessages.SIX_MATCH_PRIZE.getMessage(), lottoResult.getCount(1));
    }

    public void printTotalRevenue(double totalRevenue) {
        System.out.printf(OutputMessages.TOTAL_REVENUE.getMessage(), totalRevenue);
    }

}