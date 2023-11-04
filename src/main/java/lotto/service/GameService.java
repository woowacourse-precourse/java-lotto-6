package lotto.service;

import lotto.model.PurchaseAmount;

public class GameService {

    private int purchaseAmount;

    public int inputPurchaseAmount(String input){
        purchaseAmount = PurchaseAmount.validated(input);
        return purchaseAmount;
    }

}
