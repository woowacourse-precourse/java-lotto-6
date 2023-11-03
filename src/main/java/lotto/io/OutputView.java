package lotto.io;

import lotto.constants.ProgressMessage;

public class OutputView {

    public void printErrorMessage(String error) {
        System.out.println(error);
    }

    public void printLottoPurchasePriceMessage() {
        System.out.println(ProgressMessage.INPUT_LOTTO_PURCHASE_PRICE_MESSAGE);
    }
}
