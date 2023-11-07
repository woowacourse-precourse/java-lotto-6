package lotto;

import view.Input;
import view.Output;

public class Play {
    private final Input input = new Input();
    private final Output output = new Output();

    public void run() {
        output.printPurchase();
        String purchaseInput = input.getInput();
        Purchase purchase = new Purchase(purchaseInput);
        output.printPurchaseAmount(purchase.getPurchaseAmount());
        output.printPurchaseLotto(purchase);
    }

}
