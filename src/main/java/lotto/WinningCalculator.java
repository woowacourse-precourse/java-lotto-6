package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.WinningResult;

public class WinningCalculator {
    private List<WinningResult> winningStatistics = new ArrayList<>();

    public void calculateWinnings(List<Lotto> lottos, List<Lotto> winningLottos) {
        lottos.forEach(userLotto -> {
            int matchedNumbers = countMatchingNumbers(userLotto, winningLottos);
            boolean hasBonusNumber = userLotto.getNumbers().contains(winningLottos.get(6).getNumbers().get(0));
            WinningResult result = calculateWinningResult(matchedNumbers, hasBonusNumber);
            winningStatistics.add(result);
        });

        winningStatistics.sort((w1, w2) -> Integer.compare(w1.getRank(), w2.getRank()));
    }

    public List<WinningResult> getWinningStatistics() {
        return winningStatistics;
    }

    private int countMatchingNumbers(Lotto userLotto, List<Lotto> winningLottos) {
        return (int) userLotto.getNumbers().stream()
                .filter(winningLottos.get(0).getNumbers()::contains)
                .count();
    }

    private WinningResult calculateWinningResult(int matchedNumbers, boolean hasBonusNumber) {
        if (matchedNumbers == 6) {
            return new WinningResult(1, 2_000_000_000);
        }
        if (matchedNumbers == 5 && hasBonusNumber) {
            return new WinningResult(2, 30_000_000);
        }
        if (matchedNumbers == 5) {
            return new WinningResult(3, 1_500_000);
        }
        if (matchedNumbers == 4) {
            return new WinningResult(4, 50_000);
        }
        if (matchedNumbers == 3) {
            return new WinningResult(5, 5_000);
        }
        return new WinningResult(6, 0);
    }

    public double calculateTotalProfitRate(int purchaseAmount) {
        int totalPrize = winningStatistics.stream()
                .mapToInt(WinningResult::getPrize)
                .sum();
        return (double) totalPrize / purchaseAmount * 100;
    }
}