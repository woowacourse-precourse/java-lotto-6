package lotto.view;

import static lotto.view.InputValidator.validateEmpty;
import static lotto.view.InputValidator.validateInteger;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String ASK_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";

    public int askPurchaseAmount() {
        System.out.println(ASK_PURCHASE_AMOUNT);
        String purchaseAmount = Console.readLine();
        validateEmpty(purchaseAmount);
        validateInteger(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }
}
