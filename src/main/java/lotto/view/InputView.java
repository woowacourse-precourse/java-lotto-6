package lotto.view;

import static lotto.view.constants.OutputMessage.INPUT_PURCHASE_PRICE_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.validator.PurchasePriceValidator;

public class InputView {
    private InputView() {
    }

    public static String inputPurchasePrice() {
        String inputPurchasePrice;
        do {
            OutputView.printMessage(INPUT_PURCHASE_PRICE_MESSAGE.getMessage());
            inputPurchasePrice = Console.readLine();
        } while (!PurchasePriceValidator.validatePurchasePrice(inputPurchasePrice));
        return inputPurchasePrice;
    }
}
