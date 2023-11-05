package lotto.view;

import lotto.constant.OutputConstant;

public class OutputView {

    public void printPurchaseAmount(String purchaseAmount) {
        System.out.printf(OutputConstant.PURCHASE_RESULT.getMessage(), purchaseAmount);
    }
}
