package lotto.controller;

import lotto.model.BuyPrice;
import lotto.view.UserInput;

public class BuyPriceController {
    private BuyPrice buyPrice;
    private UserInput userInput;

    public BuyPriceController() {
        userInput = new UserInput();
    }

    public void setBuyPrice(){
        try {
            buyPrice = new BuyPrice(userInput.inputLottoBuyPrice());
        }
        catch (IllegalArgumentException e){
            System.out.println("[ERROR]:1000원 단위로 구매하세요");
            setBuyPrice();
        }

    }
}
