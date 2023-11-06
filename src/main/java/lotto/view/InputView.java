package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.PurchaseMoneyValidator;

import static lotto.constant.ConsoleMessage.INPUT_PURCHASE_MONEY;

public class InputView {

    public int inputPurchaseMoney() {
        System.out.println(INPUT_PURCHASE_MONEY);

        String purchaseMoney = null;

        while (true) {
            purchaseMoney = Console.readLine();
            try {
                PurchaseMoneyValidator.validate(purchaseMoney);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return Integer.parseInt(purchaseMoney);
    }
}
