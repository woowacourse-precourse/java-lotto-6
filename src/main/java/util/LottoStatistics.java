package util;

import lotto.LottoRank;

import java.util.Map;

public class LottoStatistics {
    private LottoStatistics() {
    }

    public static void printStatistics(Map<LottoRank, Integer> rankCounter, int ticketPurchaseAmount) {
        System.out.println("당첨 통계");
        System.out.println("-".repeat(3));

        System.out.println(LottoRank.FIFTH.getMatchedCount() + "개 일치 (" + LottoRank.FIFTH.getPrizeMoney() + "원) - " + rankCounter.get(LottoRank.FIFTH) + "개");
        System.out.println(LottoRank.FOURTH.getMatchedCount() + "개 일치 (" + LottoRank.FOURTH.getPrizeMoney() + "원) - " + rankCounter.get(LottoRank.FOURTH) + "개");
        System.out.println(LottoRank.THIRD.getMatchedCount() + "개 일치 (" + LottoRank.THIRD.getPrizeMoney() + "원) - " + rankCounter.get(LottoRank.THIRD) + "개");
        System.out.println(LottoRank.SECOND.getMatchedCount() + "개 일치, 보너스 볼 일치 (" + LottoRank.SECOND.getPrizeMoney() + "원) - " + rankCounter.get(LottoRank.SECOND) + "개");
        System.out.println(LottoRank.FIRST.getMatchedCount() + "개 일치 (" + LottoRank.FIRST.getPrizeMoney() + "원) - " + rankCounter.get(LottoRank.FIRST) + "개");
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
