package lotto.Controller;

import lotto.View.*;

public class GameController {

    public void run(){
        int purchaseAmount = this.readPurchaseAmount();
    }

    private int readPurchaseAmount(){
        while (true) {
            try {
                String purchaseAmountString = input.readPurchaseAmount();
                int purchaseAmount = Integer.parseInt(purchaseAmountString);
                if (purchaseAmount % 1000 == 0) {
                    return purchaseAmount;
                }
                error.not_valid_purchaseAmount();
            } catch (NumberFormatException e) {
                error.NAN();
            }
        }
    }
}
