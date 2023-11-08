package lotto.view;

import static lotto.view.OutputView.ASK_INPUT_MONEY;
import static lotto.view.OutputView.PURCHASE_RESULT;

public class OutputMoney {
    public static void resultMoney(int count){
        System.out.print(count);
        printMessage(PURCHASE_RESULT);
    }
    public static void printMessage(OutputView outputView) {
        System.out.println(outputView.getMessage());
    }
}
