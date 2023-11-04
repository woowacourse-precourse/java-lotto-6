package lotto.view;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Ranking;

public class OutputView {

    public int printPurchases(int numberOfLotto) {
        int number = numberOfLotto / 1000;
        System.out.println(number + "개를 구매했습니다.");
        return number;
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
        List<Ranking> ordered = Ranking.getAllRankingCase();
        for(Ranking ranking : ordered) {
            System.out.printf(ranking.getMessage(), ranking.getMachedCount(), transfer(ranking.getAmount()), results.get(ranking));
        }
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
