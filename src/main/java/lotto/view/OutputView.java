package lotto.view;

public class OutputView {

    public void printPurchaseAmount(int amount) {
        System.out.println(OutputMessage.OUTPUT_PURCHASE_AMOUNT_MESSAGE.getMessage(amount));
    }
}
