package lotto.model;

import lotto.model.constants.LottoInformation;
import lotto.model.constants.LottoPrize;

import java.util.List;

public class LottoPercentageCalculation {
    public LottoPercentageCalculation(){

    }

    public double percentageCalculation(List<LottoPrize> lottoPrizelist, LottoInformation lottoInformation) {
        double profit = 0;
        for(LottoPrize lottoPrize: lottoPrizelist){
            profit+=lottoPrize.getWinCount()*lottoPrize.getPrizeMoney();
        }
        return (profit/LottoInformation.BUY_PRICE.getValue())*100;
    }
}
