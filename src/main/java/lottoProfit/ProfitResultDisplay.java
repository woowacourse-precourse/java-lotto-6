package lottoProfit;

import lottoResult.LottoResultDisplay;

public class ProfitResultDisplay {
    public void outputProfitResult(ProfitCalculator calculator, LottoResultDisplay lottoResult, int purchaseAmount) {
        int totalReward = calculator.getTotalReward(lottoResult);
        double result = calculator.roundUpProfit(totalReward, purchaseAmount);
        System.out.printf("총 수익률은 %.1f%%입니다.", result);
    }
}