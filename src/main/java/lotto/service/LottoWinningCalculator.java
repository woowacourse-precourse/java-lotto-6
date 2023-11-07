package lotto.service;

import static lotto.service.LottoService.countMatchingNumbers;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.utils.constants.LottoWinning;

public class LottoWinningCalculator {

    public static List<Integer> lottoCalculator(List<Integer> winningNumbers, List<Lotto> purchasedLottos) {
        List<Integer> counts = new ArrayList<>();
        for (Lotto purchasedLotto : purchasedLottos) {
            int matchingNumbers = countMatchingNumbers(purchasedLotto.getNumbers(), winningNumbers);
            counts.add(matchingNumbers);
        }
        return counts;
    }

    public static void printTotalProfit(List<Integer> lottoWinningCounts, int purchaseAmount) {
        int totalPrize = 0;

        for (int i = 0; i < 6; i++) {
            int finalI = i;
            long matchingNumbers = lottoWinningCounts.stream().filter(count -> count == finalI).count();
            if (matchingNumbers > 0) {
                LottoWinning winning = LottoWinning.findByMatchValues(i);
                String prize;
                if (winning.getRank() == 2 && i == 5) {
                    prize = "5개 일치, 보너스 볼 일치";
                } else {
                    prize = i + "개 일치";
                }
                System.out.println(
                    prize + " (" + LottoWinning.formatCurrency(winning.getReward()) + "원) - " + matchingNumbers + "개");
                totalPrize += winning.getReward() * (int) matchingNumbers;
            }
        }

        double profitRate = ((double) (totalPrize - purchaseAmount) / purchaseAmount) * 100;
        System.out.println("총 수익률은 " + String.format("%.1f", profitRate) + "%입니다.");
    }
}
