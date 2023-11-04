package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.ErrorMessage;
import lotto.constants.GuideMessage;
import lotto.validate.Validate;

public class View {
    private Validate validate;

    public View() {
        validate = new Validate();
    }

    public void buyPrice() {
        System.out.println(GuideMessage.INPUT_BUY_PRICE_MESSAGE.getMessage());
        inputBuyPrice();
    }

    private int inputBuyPrice() {
        String inputPrice = Console.readLine();
        try {
            validate.errorInputBuyPrice(inputPrice);
            return Integer.parseInt(inputPrice);
        } catch (IllegalArgumentException e) {
            return inputBuyPrice();
        }
    }
}
