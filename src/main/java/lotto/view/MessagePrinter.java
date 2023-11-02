package lotto.view;

import static lotto.constant.MessageConstant.BUYING_AMOUNT_MESSAGE;
import static lotto.constant.MessageConstant.BUYING_PRICE_MESSAGE;

public class MessagePrinter {

    public void printBuyingPriceMessage() {
        System.out.println(BUYING_PRICE_MESSAGE);
    }

    public void printBuyingAmountMessage(final int buyingAmount) {
        System.out.println(buyingAmount + BUYING_AMOUNT_MESSAGE);
    }
}
