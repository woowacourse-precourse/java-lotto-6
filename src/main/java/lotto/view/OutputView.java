package lotto.view;

import lotto.constants.OutputMessage;
import lotto.domain.Lotto;
import lotto.domain.PurchaseQuantity;

import static lotto.constants.OutputMessage.ANNOUNCE_PURCHASE_QUANTITY_FORMAT;
import static lotto.util.LottoGenerator.generateLottoNumbers;

public class OutputView {

    public static void announceIssuedLottos(PurchaseQuantity quantity) {
        announcePurchaseQuantity(quantity);
        showIssuedLottos(quantity);
    }

    public static void announcePurchaseQuantity(PurchaseQuantity purchaseQuantity) {
        printObject(ANNOUNCE_PURCHASE_QUANTITY_FORMAT, purchaseQuantity);
        lineBreak();
    }

    private static void showIssuedLottos(PurchaseQuantity quantity) {
        quantity.forEach((repeat) -> {
            printObject(new Lotto(generateLottoNumbers()));
            lineBreak();
        });
    }

    public static void printObject(OutputMessage outputMessage, Object object) {
        System.out.print(String.format(outputMessage.getMessage(), object.toString()));
    }

    public static void printObject(Object object) {
        System.out.print(String.format(object.toString()));
    }

    public static void lineBreak() {
        System.out.println();
    }
}
