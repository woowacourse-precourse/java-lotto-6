package lotto;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Calculator {
    private double yield;
    private Map<Rank, Long> rankCounts;

    Calculator(int price, List<LottoResult> result) {
        totalCalculate(result);
        calculateYield(price);
        printTotalResult();
    }

    private void totalCalculate(List<LottoResult> result) {
        rankCounts = result.stream()
                .map(LottoResult::getRank)
                .filter(rank -> rank != null)
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));
    }

    private void calculateYield(int price) {
        int totalPrize = rankCounts.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrizeAsInt() * entry.getValue().intValue())
                .sum();
        yield = (double) totalPrize / (double) price * 100.0;
    }

    public void printTotalResult() {
        DecimalFormat df = new DecimalFormat("#.##");
        String formattedRate = df.format(yield);
        System.out.println("당첨 통계");
        System.out.println("---------");
        List<Rank> ranksInReverseOrder = Arrays.asList(Rank.values());
        Collections.reverse(ranksInReverseOrder);
        for (Rank rank : ranksInReverseOrder) {
            if (rank == Rank.NONE) {
                continue;
            }
            long count = rankCounts.getOrDefault(rank, 0L);
            System.out.println(rank.getDescription() + " - " + count + "개");
        }
        System.out.println("총 수익률은 " + formattedRate + "%입니다.");
    }
}
