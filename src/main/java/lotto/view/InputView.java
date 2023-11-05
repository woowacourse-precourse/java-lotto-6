package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.PurchasePriceValidator;

public class InputView {
    private static final PurchasePriceValidator purcharPriceValidator = new PurchasePriceValidator();

    public int getPurchasePrice() {
        String purchasePrice = "";

        while (true) {
            try {
                System.out.println(InputMessage.REQUEST_PURCHASE_PRICE.getMessage());
                purchasePrice = Console.readLine();
                purcharPriceValidator.validate(purchasePrice);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return Integer.parseInt(purchasePrice);
    }
}
