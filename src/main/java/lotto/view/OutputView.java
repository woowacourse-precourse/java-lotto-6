package lotto.view;

import lotto.utils.PrintingMessage;

public class OutputView {
    public void printGetPurchaseAmountMessage() {
        System.out.println(PrintingMessage.GET_PURCHASE_AMOUNT_MESSAGE.get());
    }

    public void printBuyingMessage(int lottoCount) {
        System.out.println(PrintingMessage.BUYING_MESSAGE.getWithFormat(lottoCount));
    }
}
