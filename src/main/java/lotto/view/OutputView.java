package lotto.view;

import static lotto.model.Ranking.*;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Ranking;

public class OutputView {

    public void printPurchases(int ticketCount) {
        System.out.println();
        System.out.println(ticketCount + "개를 구매했습니다.");
    }

    public void printIssuedLotto(List<Lotto> issuedLotto) {
        for(Lotto lotto : issuedLotto) {
            String result = Arrays.toString(lotto.getNumbers().toArray());
            System.out.println(result);
        }
    }

    public void printLotteryStatistics() {
        System.out.println();
        System.out.println("당첨 통계\n---");
    }

    public void printStatisticsResult(Map<Ranking, Integer> results) {
        getAllRankingCase().stream()
            .filter(ranking -> ranking != NOTHING)
            .forEach(ranking -> System.out.printf(
                ranking.getMessage(),
                ranking.getMatchedCount(),
                transfer(ranking.getAmount()),
                results.get(ranking)
            ));
    }

    private String transfer(int price) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(price);
    }

    public void printRateOfReturn(float result) {
        System.out.println();
        System.out.printf("총 수익률은 %.1f%%입니다.", result);
    }
}
