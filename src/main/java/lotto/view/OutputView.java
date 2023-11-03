package lotto.view;

import lotto.constants.OutputConstants;

public class OutputView {

    private OutputView() {}

    public static void printInputPurchaseAmount() {
        System.out.println(OutputConstants.INPUT_PURCHASE_AMOUNT.getValue());
    }
}
