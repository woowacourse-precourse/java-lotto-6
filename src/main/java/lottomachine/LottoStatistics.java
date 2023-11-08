package lottomachine;

import java.text.DecimalFormat;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class LottoStatistics {

    private final Map<LottoPrize, Integer> prizeCount = new HashMap<>();
    private int totalSpent = 0;
    private int totalPrize = 0;
    private List<LottoResult> lottoResults;

    public LottoStatistics(List<LottoResult> lottoResults) {
        this.lottoResults = lottoResults;
        this.totalSpent = lottoResults.size() * 1000;
        initializePrizeCount();
        calculatePrizes();
    }

    private void initializePrizeCount() {
        for (LottoPrize prize : LottoPrize.values()) {
            prizeCount.put(prize, 0);
        }
    }

    private void calculatePrizes() {
        for (LottoResult result : lottoResults) {
            LottoPrize prize = LottoPrize.valueOf(result.getMatchCount(), result.getBonusMatch());
            if (prize != null) {
                prizeCount.put(prize, prizeCount.get(prize) + 1);
                totalPrize += prize.getPrizeMoney();
            }
        }
    }

    public void printStatistics() {
        DecimalFormat formatter = new DecimalFormat("#,###원");
        LottoPrize[] prizes = LottoPrize.values();
        for (int i = prizes.length - 1; i >= 0; i--) {
            LottoPrize prize = prizes[i];
            int count = prizeCount.get(prize);
            System.out.println(prize.getMatchCount() + "개 일치" +
                    (prize.isBonusMatch() ? ", 보너스 볼 일치 " : " ") +
                    "(" + formatter.format(prize.getPrizeMoney()) + ") - " +
                    count + "개");
        }

        double roi = ((double) totalPrize / totalSpent) * 100;
        System.out.println("총 수익률은 " + String.format("%.1f", roi) + "%입니다.");
    }
}
