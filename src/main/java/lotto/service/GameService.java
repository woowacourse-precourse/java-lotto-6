package lotto.service;

import lotto.model.PurchaseAmount;

public class GameService {

    private int purchaseAmount;

    public void inputPurchaseAmount(String input){
        purchaseAmount = PurchaseAmount.validated(input);
    }

}
