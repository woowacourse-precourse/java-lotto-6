package lotto.model;

import lotto.model.constants.LottoPrize;

public class LottoPercentageCalculation {

    public double percentageCalculation(LottoPrize[] values, int lottoPrice) {
        double profit = 0;
        for(LottoPrize lottoPrize: values){
            profit+=lottoPrize.getWinCount()*lottoPrize.getPrizeMoney();
        }
        return (profit/lottoPrice)*100;
    }
}
