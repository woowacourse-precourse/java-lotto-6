package lotto.view;

import lotto.constant.Views;

public class LottoView {

    public void inputPurchaseAmountView(){
        System.out.println(Views.INPUT_PURCHASE_AMOUT_MESSAGE.getMessage());
    }

    public void outputPurchaseAmountView(int amount){
        System.out.println();
        System.out.println(amount + Views.OUTPUT_PURCHASE_AMOUT_MESSAGE.getMessage());
    }
}
