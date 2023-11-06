package lotto.views;

import camp.nextstep.edu.missionutils.Console;
import lotto.valid.PurchaseMoneyValidator;

public class InputView {

    private static final String INPUT_PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요.";

    public static int inputPurchaseMoney() {
        System.out.println(INPUT_PURCHASE_MONEY_MESSAGE);
        String input = Console.readLine();

        // 잘못된 값을 입력받았을 경우 반복
        while (!PurchaseMoneyValidator.validate(input)) {
            System.out.println(INPUT_PURCHASE_MONEY_MESSAGE);
            input = Console.readLine();
        }

        return Integer.parseInt(input);
    }
}
