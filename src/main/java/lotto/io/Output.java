package lotto.io;

public class Output {

    public void printInputPurchaseAmountMessage() {
        System.out.println(Constants.PURCHASE_AMOUNT_MESSAGE);
    }

    public void printPurchaseQuantity(int lottoQuantity) {
        System.out.println();
        System.out.printf(Constants.QUANTITY_MESSAGE, lottoQuantity);
    }
}
