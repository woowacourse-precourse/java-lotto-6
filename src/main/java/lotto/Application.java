package lotto;

import view.Input;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = inputPurchaseAmount();
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
