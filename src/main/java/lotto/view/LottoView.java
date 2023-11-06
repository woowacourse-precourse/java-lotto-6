package lotto.view;

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
    }

    public void printInputWinningNumber(){
        System.out.println(Views.INPUT_WINNING_NUMBER_MESSAGE);
    }

    public void printInputBonusNumber(){
        System.out.println(Views.INPUT_BONUS_NUMBER_MESSAGE);
    }
}
