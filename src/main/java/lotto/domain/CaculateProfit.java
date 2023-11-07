package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class CaculateProfit {


    private final int lottoPurchaseCnt;
    private final List<Integer> cntProfit;
    private final List<Integer> bonusProfit;

    private final List<Integer> totalProfit;

    private final List<Integer> lottoResult;

    private final List<Boolean> bonusCheck;

    public CaculateProfit(int lottoPurchaseCnt ,List<Integer> lottoResult, List<Boolean> bonusCheck) {
        this.lottoPurchaseCnt = lottoPurchaseCnt;
        this.lottoResult = lottoResult;
        this.bonusCheck = bonusCheck;

        this.cntProfit = calculateCntProfit();
    }

    private List<Integer> calculateCntProfit() {
        List<Integer> cntProfit = new ArrayList<>();

        for(int i = 0; i < lottoPurchaseCnt; i++) {
            int cnt = lottoResult.get(i);
            int profit = 0;

            if (cnt == 3) {
                profit = 5000;
            } else if (cnt == 4) {
                profit = 50000;
            } else if (cnt == 5) {
                profit = 15000000;
            } else if (cnt == 6) {
                profit = 2000000000;
            }

            cntProfit.add(profit);
        }

        return cntProfit;
    }
}
