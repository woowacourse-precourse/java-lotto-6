package lotto;

import java.util.List;

public class Calculator {

    public int getProfitMoney(List<MatchingCount> lottoResults) {
        int sum = 0;
        for (MatchingCount lottoMatching : lottoResults) {
            int prize = lottoMatching.getPrizeMoney();
            sum += prize;
        }
        return sum;
    }

    public double getProfitPercentage(int sumPrize, int lottoVolume) {
        int initialMoney = lottoVolume * 1000;
        double profitPer = (double) sumPrize / initialMoney * 100;
        profitPer = Math.round(profitPer * 10d) / 10d;
        return profitPer;
    }
}
