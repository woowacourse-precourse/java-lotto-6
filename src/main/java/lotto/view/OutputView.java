package lotto.view;

import lotto.constant.OutputMessage;

public class OutputView {

    public void printPurchaseMessage() {
        System.out.println(OutputMessage.PURCHASE_AMOUNT.getMessage());
    }
}