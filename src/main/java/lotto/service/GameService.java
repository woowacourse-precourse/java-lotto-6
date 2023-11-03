package lotto.service;

import lotto.model.BuyPrice;

public class GameService {

    private int buyPrice;

    public void inputBuyPrice(String input){
        buyPrice = BuyPrice.validated(input);
    }

}
