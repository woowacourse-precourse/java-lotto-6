package lotto.controller;

import lotto.model.CountOfCorrectLotto;
import lotto.model.LottoPrice;
import lotto.model.NumberOfPurchaseLotto;
import lotto.model.WinningDetail;

public class TotalReturnCalculator {
    public Double calculateTotalReturn(WinningDetail winningDetail, NumberOfPurchaseLotto numberOfPurchaseLotto){
        Double totalReturn = 0.0;
        Double totalPrize = 0.0;
        for(CountOfCorrectLotto countOfCorrectLotto : winningDetail.getCountOfCorrectLottos()){
            totalPrize += countOfCorrectLotto.getCount() * countOfCorrectLotto.getWinningPrize();
        }
        Double totalPayment = (double) LottoPrice.PRICE.getValue() * numberOfPurchaseLotto.getNumberOfPurchaseLotto();
        totalReturn = totalPrize / totalPayment * 100.0;
        return totalReturn;
    }
}
