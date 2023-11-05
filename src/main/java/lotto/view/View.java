package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.GuideMessage;
import lotto.domain.Buy;
import lotto.validate.Validate;

public class View {
    private final Validate validate;

    public View() {
        validate = new Validate();
    }

    public int buyPrice() {
        System.out.println(GuideMessage.INPUT_BUY_PRICE_MESSAGE.getMessage());
        return inputBuyPrice();
    }

    public void buyTicketCount(int ticketCount) {
        System.out.println(ticketCount + GuideMessage.OUTPUT_BUY_LOTTO_COUNT_MESSAGE.getMessage());
    }

    private int inputBuyPrice() {
        String inputPrice = Console.readLine();
        try {
            validate.buyPriceValidate(inputPrice);
            return Integer.parseInt(inputPrice);
        } catch (IllegalArgumentException e) {
            return inputBuyPrice();
        }
    }
}
