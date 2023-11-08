package util;

import lotto.LottoRank;

import java.util.Map;

public class LottoStatistics {
    private LottoStatistics() {
    }

    public static void printStatistics(Map<LottoRank, Integer> rankCounter, int ticketPurchaseAmount) {
        System.out.println("당첨 통계");
        System.out.println("-".repeat(3));

        final String WON = "원) - ";
        final String COUNT = "개";
        final String matchedCount = "개 일치 (";
        
        System.out.println(LottoRank.FIFTH.getMatchedCount() + matchedCount + LottoRank.FIFTH.getPrizeMoney() + WON + rankCounter.get(LottoRank.FIFTH) + COUNT);
        System.out.println(LottoRank.FOURTH.getMatchedCount() + matchedCount + LottoRank.FOURTH.getPrizeMoney() + WON + rankCounter.get(LottoRank.FOURTH) + COUNT);
        System.out.println(LottoRank.THIRD.getMatchedCount() + matchedCount + LottoRank.THIRD.getPrizeMoney() + WON + rankCounter.get(LottoRank.THIRD) + COUNT);
        System.out.println(LottoRank.SECOND.getMatchedCount() + "개 일치, 보너스 볼 일치 (" + LottoRank.SECOND.getPrizeMoney() + WON + rankCounter.get(LottoRank.SECOND) + COUNT);
        System.out.println(LottoRank.FIRST.getMatchedCount() + matchedCount + LottoRank.FIRST.getPrizeMoney() + WON + rankCounter.get(LottoRank.FIRST) + COUNT);
        System.out.printf("총 수익률은 %.1f%%입니다.", calculateYield(rankCounter, ticketPurchaseAmount));
    }

    static double calculateYield(Map<LottoRank, Integer> rankCounter, int ticketPurchaseAmount) {
        int totalPrizeMoney = rankCounter.entrySet().stream()
                .mapToInt(entry -> Integer.parseInt(
                        entry.getKey()
                                .getPrizeMoney()
                                .replace(",", "")) * entry.getValue())
                .sum();

        return (double) totalPrizeMoney / (ticketPurchaseAmount) * 100;
    }
}
