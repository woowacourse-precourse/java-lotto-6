package lotto.view;

import lotto.constant.Ranking;
import lotto.constant.Views;
import lotto.domain.Lotto;


import java.util.List;

public class LottoView {

    public void inputPurchaseAmountView(){
        System.out.println(Views.INPUT_PURCHASE_AMOUT_MESSAGE.getMessage());
    }

    public void outputPurchaseAmountView(int amount){
        System.out.println();
        System.out.println(amount + Views.OUTPUT_PURCHASE_AMOUT_MESSAGE.getMessage());
    }

    public void printPurchaseLotto(List<Lotto> lotts){
        for(Lotto lotto : lotts){
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public void printInputWinningNumber(){
        System.out.println(Views.INPUT_WINNING_NUMBER_MESSAGE.getMessage());
    }

    public void printInputBonusNumber(){
        System.out.println();
        System.out.println(Views.INPUT_BONUS_NUMBER_MESSAGE.getMessage());
    }

    public void printWinningMessage(){
        System.out.println();
        System.out.println(Views.OUTPUT_WINNING_RESULT.getMessage());
        System.out.println(Views.OUTPUT_UNDER_BAR.getMessage());
    }

    public void printWinningResult(int[] winResult){
        for(Ranking ranking : Ranking.values()){
            String getWinningMessage = ranking.formatMessage(winResult[ranking.getIndex()]);
            System.out.println(getWinningMessage);
        }
    }

    public void printRate(String winRate){
        String getResultRateMessage = Views.OUTPUT_RATE_RESULT_MESSAGE.formatMessage(winRate);
        System.out.println(getResultRateMessage);
    }
}
