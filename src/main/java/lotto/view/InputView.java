package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.PurchaseAmountValidator;

public class InputView {
    private static final String PROMPT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";

    public int readPurchaseAmount() {
        try {
            System.out.println(PROMPT_PURCHASE_AMOUNT);
            String userInput = Console.readLine();
            new PurchaseAmountValidator().validate(userInput);

            return Integer.parseInt(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readPurchaseAmount();
        }
    }
}
