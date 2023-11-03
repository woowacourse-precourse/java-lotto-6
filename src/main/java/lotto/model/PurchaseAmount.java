package lotto.model;

import lotto.view.ErrorOutputView;
import lotto.view.InputView;

public class PurchaseAmount {

    public static int validated(String input){
        empty(input);
        return 0; //임시
    }

    private static void empty(String input){
        if(input.length() == 0){
            ErrorOutputView.emptyPurchaseAmountMessage();
            throw new IllegalArgumentException();
        }
    }

}
