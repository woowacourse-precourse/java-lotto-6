package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.constants.OutputMessages;
import lotto.domain.Winning;

public class OutputView {
    private static final int HUNDRED = 100;

    public void printLottoCount(int lottoCount) {
        System.out.printf(OutputMessages.LOTTO_COUNT.getMessage(), lottoCount);
    }

    public void printLottoNumbers(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public void getInputAmount() {
        System.out.println(OutputMessages.LOTTO_PURCHASE_AMOUNT.getMessage());
    }

    public void getInputWinningNumbers() {
        System.out.println(OutputMessages.WINNING_NUMBERS.getMessage());
    }

    public void getInputBonusNumber() {
        System.out.println(OutputMessages.BONUS_NUMBER.getMessage());
    }

    public void printWinningStatistics() {
        System.out.println(OutputMessages.WINNING_STATISTICS.getMessage());
        System.out.println(OutputMessages.WINNING_STATISTICS_DELIMITER.getMessage());
    }

    public void printStatistics(Map<Winning, Integer> winningCounts, double totalPrize, double totalCost) {
        for (Winning result : Winning.values()) {
            if (result == Winning.NOT_WINNING) {
                continue;
            }
            String resultName = result.getMatchCount() + "개 일치";
            if (result == Winning.FIFTH_BONUS) {
                resultName = OutputMessages.FIFTH_BONUS_RESULT.getMessage();
            }
            int count = winningCounts.getOrDefault(result, 0);
            int prize = result.getWinningAmount().amount();
            String message = String.format(OutputMessages.MATCH_RESULT.getMessage(), resultName, prize, count);
            System.out.println(message);
        }
        double profit = totalPrize - totalCost;
        double profitPercentage = HUNDRED + (profit / totalCost) * HUNDRED;
        System.out.printf(OutputMessages.PROFIT_MESSAGE.getMessage(), profitPercentage);
    }
}