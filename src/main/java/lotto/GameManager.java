package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.domain.WinningStatistics;

public class GameManager {
    private static final int LOTTO_AMOUNT = 1000;
    private static final int FIVE_MATCHES = 5;
    private static final int MINIMUM_MATCHES = 3;
    private static final int PERCENTAGE = 100;

    public List<Lotto> createLotto(int purchaseAmount) {
        List<Lotto> totalLotto = new ArrayList<>();
        int purchaseQuantity = purchaseAmount / LOTTO_AMOUNT;

        IntStream.range(0, purchaseQuantity)
                .forEach(i -> {
                    List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
                    Lotto lotto = new Lotto(lottoNumbers);
                    totalLotto.add(lotto);
                });

        return totalLotto;
    }

    public void compareTotalLotto(
            List<Lotto> totalLotto,
            List<Integer> winningNumbers,
            int bonusNumber,
            WinningStatistics winningStatistics
    ) {
        for (Lotto lotto : totalLotto) {
            compareLottoWithWinningNumbers(lotto, winningNumbers, bonusNumber, winningStatistics);
        }
    }

    private WinningStatistics compareLottoWithWinningNumbers(
            Lotto lotto,
            List<Integer> winningNumbers,
            int bonusNumber,
            WinningStatistics winningStatistics
    ) {
        int matchCount = lotto.getNumbers().stream().filter(winningNumbers::contains).toList().size();

        updateWinningStatistics(lotto, matchCount, bonusNumber, winningStatistics);

        return winningStatistics;
    }

    private void updateWinningStatistics(
            Lotto lotto,
            int matchCount,
            int bonusNumber,
            WinningStatistics winningStatistics
    ) {
        if (matchCount == FIVE_MATCHES) {
            winningStatistics.incrementWinningStatus(Ranking.compareLottoWithBonusNumber(lotto, bonusNumber));
            return;
        }

        if (matchCount >= MINIMUM_MATCHES) {
            winningStatistics.incrementWinningStatus(Ranking.findByMatchCount(matchCount));
        }
    }

    public String calculateProfitPercentage(WinningStatistics winningStatistics, int purchaseAmount) {
        int totalWinningAmount = calculateTotalWinningAmount(winningStatistics);
        double profit = ((double) totalWinningAmount / purchaseAmount) * PERCENTAGE;
        BigDecimal bigDecimal = BigDecimal.valueOf((long) profit, 1);
        return bigDecimal.toString();
    }

    private int calculateTotalWinningAmount(WinningStatistics winningStatistics) {
        int totalWinningAmount = 0;
        Map<Ranking, Integer> winningResult = winningStatistics.getWinningStatus();

        for (Ranking ranking : winningResult.keySet()) {
            totalWinningAmount += ranking.getWinningAmount() * winningResult.get(ranking);
        }

        return totalWinningAmount;
    }
}
