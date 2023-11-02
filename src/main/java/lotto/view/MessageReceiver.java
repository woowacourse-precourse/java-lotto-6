package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class MessageReceiver {

    private final ViewValidator viewValidator;

    public MessageReceiver(final ViewValidator viewValidator) {
        this.viewValidator = viewValidator;
    }

    public void receiveBuyingPrice() {
        boolean validInput = false;

        while (!validInput) {
            String buyingPriceText = Console.readLine();
            validInput = viewValidator.validateBuyingPrice(buyingPriceText);
        }
    }
}
