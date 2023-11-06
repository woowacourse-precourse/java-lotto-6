package lotto;

import view.Input;
import view.Output;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = inputPurchaseAmount();
        Lotteries lotteries = new Lotteries(purchaseAmount);
        Output.printIssuedLotto(lotteries.getLotteries());
    }

    private static int inputPurchaseAmount() {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount();
        try {
            String input = Input.inputPurchaseAmount();
            lottoPurchaseAmount = new LottoPurchaseAmount(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputPurchaseAmount();
        }
        return lottoPurchaseAmount.getPurchaseAmount();
    }
}
