package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class CalculateProfit {


    private final int lottoPurchase;

    private final List<Integer> lottoResult;

    private final List<Boolean> bonusCheck;

    private final List<Integer> cntProfit;
    private final List<Integer> bonusProfit;

    private final List<Integer> totalProfit;

    private final double rateOfReturn;


    public List<Integer> getTotalProfit() {
        return totalProfit;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }





    public CalculateProfit(int lottoPurchase ,List<Integer> lottoResult, List<Boolean> bonusCheck) {
        this.lottoPurchase = lottoPurchase;
        this.lottoResult = lottoResult;
        this.bonusCheck = bonusCheck;

        this.cntProfit = calculateCntProfit();
        this.bonusProfit = calculateBonusProfit();
        this.totalProfit = calculateTotalProfit();

        this.rateOfReturn = calculateRateOfReturn();
    }

    private List<Integer> calculateCntProfit() {
        List<Integer> cntProfit = new ArrayList<>();

        if (lottoResult.isEmpty())
            return cntProfit;

        for(int i = 0; i < lottoResult.size(); i++) {
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

    private List<Integer> calculateBonusProfit() {
        List<Integer> bonusProfit = new ArrayList<>();

        if (lottoResult.isEmpty())
                return bonusProfit;

        for(int i = 0; i < lottoResult.size(); i++) {
            int cnt = lottoResult.get(i);
            boolean bonus = bonusCheck.get(i);
            int profit = 0;


            if (cnt == 5 && bonus) {
                profit = 15000000;
            }

            bonusProfit.add(profit);
        }

        return bonusProfit;
    }

    private List<Integer> calculateTotalProfit() {
        List<Integer> totalProfit = new ArrayList<>();

        if (lottoResult.isEmpty())
            return totalProfit;

        for(int i = 0; i < lottoResult.size(); i++)
        {
            int profit = cntProfit.get(i) + bonusProfit.get(i);
            totalProfit.add(profit);
        }

        return totalProfit;
    }

    private double calculateRateOfReturn() {
        long sum = 0;

        for (int n : totalProfit) {
            sum += n;
        }

        return (double) sum / lottoPurchase;
    }
}
