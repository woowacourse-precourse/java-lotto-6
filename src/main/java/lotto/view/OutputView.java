package lotto.view;

import lotto.constants.OutputMessage;
import lotto.domain.PurchaseQuantity;

import static lotto.constants.OutputMessage.ANNOUNCE_PURCHASE_QUANTITY_FORMAT;

public class OutputView {

    public static void announcePurchaseQuantity(PurchaseQuantity purchaseQuantity) {
        printObject(ANNOUNCE_PURCHASE_QUANTITY_FORMAT, purchaseQuantity);
        lineBreak();
    }

    public static void printObject(OutputMessage outputMessage, Object object) {
        System.out.print(String.format(outputMessage.getMessage(), object.toString()));
    }

    public static void lineBreak() {
        System.out.println();
    }
}
