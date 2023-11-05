package lotto.view;

import static lotto.constant.OutputText.ENTER_PURCHASE_AMOUNT;

import lotto.constant.OutputText;

public class OutputView {

    public void printEnterPurchaseAmount() {
        printText(ENTER_PURCHASE_AMOUNT);
    }

    private void printText(OutputText outputText) {
        System.out.println(outputText.toString());
    }
}
