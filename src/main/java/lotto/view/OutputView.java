package lotto.view;

import static lotto.constant.PrintMessage.*;

public class OutputView {
    public static void inputPurchaseAmountMessage(){
        System.out.println(INPUT_PURCHASE_AMOUNT);
    }

    public static void errorMessage(String s){
        System.out.println(s);
    }
}
