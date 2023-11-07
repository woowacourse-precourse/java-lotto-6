package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Winning;

public class OutputView {
    private static final String LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String LOTTO_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String WINNING_STATISTICS_DELIMITER = "---------";

    public void printLottoCount(int lottoCount) {
        System.out.printf(LOTTO_COUNT_MESSAGE, lottoCount);
    }

    public void printLottoNumbers(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public void getInputAmount() {
        System.out.println(LOTTO_PURCHASE_AMOUNT_MESSAGE);
    }

    public void getInputWinningNumbers() {
        System.out.println(WINNING_NUMBERS_MESSAGE);
    }

    public void getInputBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
    }

    public void printWinningStatistics() {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(WINNING_STATISTICS_DELIMITER);
    }
    // OutputView.java

    public void printStatistics(Map<Winning, Integer> winningCounts, double totalPrize, double totalCost) {
        for (Winning result : Winning.values()) {
            if (result == Winning.DEFAULT) {
                continue;
            }
            String resultName = result.getMatchCount() + "개 일치";
            if (result == Winning.FIFTH_BONUS) {
                resultName = "5개 일치, 보너스 볼 일치";
            }
            int count = winningCounts.getOrDefault(result, 0);
            int prize = result.getWinningAmount();
            String message = String.format("%s (%,d원) - %d개", resultName, prize, count);
            System.out.println(message);
        }
        double profit = totalPrize - totalCost;
        double profitPercentage = 100 + (profit / totalCost) * 100;
        System.out.println("총 수익률은 " + String.format("%.1f", profitPercentage) + "%" + "입니다.");
    }
}
