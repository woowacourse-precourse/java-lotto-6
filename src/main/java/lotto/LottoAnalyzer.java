package lotto;

import java.util.List;

public class LottoAnalyzer {

    public double getProfitRate(int[] matchCounts ,int purchaseAmount) {
        // 수익률 구하는 함수
        // 수익률 = ((돈 * 해당 개수) / 구매 금액) * 100
        //소수점 둘째 자리에서 반올림
        double sum = 0;
        int[] money = {5000,50000,1500000,2000000000,30000000};
        for(int i=0; i<matchCounts.length; i++){
            sum += money[i]*matchCounts[i];
        }
        double profit = (sum / purchaseAmount) * 100.0;
        double newProfit = Math.round(profit*100.0)/100.0;
        return newProfit;
    }

}
