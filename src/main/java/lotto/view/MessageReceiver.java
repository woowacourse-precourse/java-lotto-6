package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class MessageReceiver {

    private final ViewValidator viewValidator;

    public MessageReceiver(final ViewValidator viewValidator) {
        this.viewValidator = viewValidator;
    }

    public int receiveBuyingPrice() {
        boolean validInput = false;
        int buyingPrice = 0;

        while (!validInput) {
            String buyingPriceText = Console.readLine();
            buyingPrice = Integer.parseInt(buyingPriceText);
            validInput = viewValidator.validateBuyingPrice(buyingPrice);
        }

        return buyingPrice;
    }
}
