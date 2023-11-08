package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.MessageDisplay;

public class UserInputController {

    public static int getLottoBuyingPrice() {
        boolean exceptionThrown = true;
        int buyingPrice = 0;
        MessageDisplay.enterBuyingPrice();
        while (exceptionThrown) {
            String userInput = Console.readLine();
            try {
                buyingPrice = UserInputValidator.isValidBuyingPrice(userInput);
                exceptionThrown = false;
            } catch (IllegalArgumentException e) {
                System.out.println("[Error]" + e.getMessage());
            }
        }
        return buyingPrice;
    }
}
