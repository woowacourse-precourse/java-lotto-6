package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = InputView.getPurchaseAmountInput();
        List<Lotto> lotteries = LottoGenerator.generateLotteries(purchaseAmount);
        OutputView.printPurchasedLotteryNumbers(lotteries);
        List<Integer> winningNumbers = InputView.getWinningNumbers();
        int bonusNumber = InputView.getBonusNumberInput(winningNumbers);
        Map<Rank, Integer> result = calculateResult(lotteries, winningNumbers, bonusNumber);
        OutputView.printResultStatistics(result);
        OutputView.printProfit(calculateProfit(purchaseAmount, result));
    }

    private static Map<Rank, Integer> calculateResult(List<Lotto> lotteries,
                                                      List<Integer> winningNumbers, int bonusNumber) {
        Map<Rank, Integer> result = new HashMap<>();
        Arrays.stream(Rank.values()).forEach(rank -> result.put(rank, Unit.ZERO.getUnit()));
        for (Lotto lottery : lotteries) {
            lottery.getRank(winningNumbers, bonusNumber).ifPresent(rank ->
                    result.put(rank, result.get(rank) + Unit.ONE.getUnit()));
        }
        return result;
    }

    private static double calculateProfit(int purchaseAmount, Map<Rank, Integer> result) {
        long totalPrize = 0L;
        for (Rank rank : Rank.values()) {
            totalPrize = totalPrize + ((long) rank.getPrize() * result.get(rank));
        }
        return (double) totalPrize /
                (purchaseAmount * Unit.PURCHASE_AMOUNT_UNIT.getUnit()) * Unit.PERCENTAGE.getUnit();
    }
}
