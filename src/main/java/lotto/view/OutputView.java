package lotto.view;

import lotto.model.LottoResult;
import lotto.model.Prize;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OutputView {
    public void printLottos(int count,List<List<Integer>> lottos) {
        System.out.println(count + "개를 구매했습니다.");
        for (List<Integer> lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void printLottoResult(LottoResult result, int purchaseAmount) {
        System.out.println("당첨 통계");
        System.out.println("---");

        Map<Prize, Integer> prizeStatistics = result.getPrizeStatistics();
        List<String> resultLines = new ArrayList<>();

        resultLines.add(buildResultLine(prizeStatistics, Prize.FIFTH, "3개 일치 (5,000원)"));
        resultLines.add(buildResultLine(prizeStatistics, Prize.FOURTH, "4개 일치 (50,000원)"));
        resultLines.add(buildResultLine(prizeStatistics, Prize.THIRD, "5개 일치 (1,500,000원)"));
        resultLines.add(buildResultLine(prizeStatistics, Prize.SECOND, "5개 일치, 보너스 볼 일치 (30,000,000원)"));
        resultLines.add(buildResultLine(prizeStatistics, Prize.FIRST, "6개 일치 (2,000,000,000원)"));

        resultLines.add("총 수익률은 " + String.format("%.1f%%", result.calculateProfitRate(purchaseAmount))+"입니다.");

        resultLines.forEach(System.out::println);
    }

    private String buildResultLine(Map<Prize, Integer> prizeStatistics, Prize prize, String description) {
        int count = prizeStatistics.getOrDefault(prize, 0);
        if (count > 0) {
            int prizeAmount = prize.getAmount();
            String formattedPrizeAmount = String.format("%,d원", prizeAmount);
            return description + " - " + count + "개 - " + formattedPrizeAmount;
        }
        return description + " - " + count + "개";
    }
}
