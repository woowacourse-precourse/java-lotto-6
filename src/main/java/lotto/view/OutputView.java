package lotto.view;

import static lotto.view.OutputMessage.PURCHASE_RESULT;

public class OutputView {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void purchaseResult(int number) {
        System.out.println(number + PURCHASE_RESULT.getMessage());
    }
}
