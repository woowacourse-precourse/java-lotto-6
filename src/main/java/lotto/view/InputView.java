package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.InputConstant;

public class InputView {

    public String inputPurchaseAmount() {
        System.out.println(InputConstant.PURCHASE_AMOUNT.getMessage());
        String purchaseAmount = getUserInput();
        return purchaseAmount;
    }

    private String getUserInput() {
        return Console.readLine();
    }
}
