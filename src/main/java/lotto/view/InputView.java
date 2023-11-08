package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String receivePurchaseAmountMsg(){
        OutputView.printInputPurchaseAmountMsg();
        return Console.readLine();
    }

    public static String receiveInputWinningNumberMsg(){
        OutputView.printInputWinningNumberMsg();
        return Console.readLine();
    }

    public static String receiveInputBonusNumberMsg(){
        OutputView.printInputBonusNumberMsg();
        return Console.readLine();
    }
}
