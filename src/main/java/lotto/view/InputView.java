package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String receivePurchaseAmountMsg(){
        OutputView.printInputPurchaseAmountMsg();
        return Console.readLine();
    }
}
