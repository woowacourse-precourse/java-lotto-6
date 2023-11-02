package lotto.controller;

import lotto.model.CountOfCorrectLotto;
import lotto.model.LottoMetaData;
import lotto.model.NumberOfPurchaseLotto;
import lotto.model.WinningDetail;

public class TotalReturnCalculator {
    public Double calculateTotalReturn(WinningDetail winningDetail, NumberOfPurchaseLotto numberOfPurchaseLotto){
        double totalPrize = 0.0;
        for(CountOfCorrectLotto countOfCorrectLotto : winningDetail.getCountOfCorrectLottos()){
            totalPrize += countOfCorrectLotto.getCount() * countOfCorrectLotto.getWinningPrize();
        }
        double totalPayment = (double) LottoMetaData.PRICE.getValue() * numberOfPurchaseLotto.getNumberOfPurchaseLotto();
        double totalReturn = totalPrize / totalPayment * 100.0;
        return totalReturn;
    }
}
