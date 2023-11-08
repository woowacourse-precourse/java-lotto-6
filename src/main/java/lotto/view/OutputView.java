package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.utils.LottoStatisticsFormatter;
import lotto.utils.ProfitCalculator;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void displayLottos(int lottoSize, List<Lotto> lottos) {
        System.out.println("\n" + lottoSize + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void displayResults(Map<LottoRank, Integer> resultMap) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        List<String> statisticsLines = LottoStatisticsFormatter.formatStatistics(resultMap);
        for (String line : statisticsLines) {
            System.out.println(line);
        }
    }

    public void displayProfitRate(Map<LottoRank, Integer> results, int purchaseAmount) {
        double roundedProfitRate = ProfitCalculator.calculateProfitRate(results, purchaseAmount);
        System.out.printf("총 수익률은 %.1f%%입니다.%n", roundedProfitRate);
    }

    public void displayError(String message) {
        System.err.println(message);
    }
}
