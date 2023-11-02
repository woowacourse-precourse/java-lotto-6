package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class MessageReceiver {

    private final ViewValidator viewValidator;

    public MessageReceiver(final ViewValidator viewValidator) {
        this.viewValidator = viewValidator;
    }

    public void receiveBuyingPrice() {
        String buyingPriceText = Console.readLine();
        viewValidator.validateBuyingPrice(buyingPriceText);
    }
}
