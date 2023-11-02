package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.InputConstant;

public class InputView {

    public String inputPurchaseAmount() {
        System.out.println(InputConstant.PURCHASE_AMOUNT.getMessage());
        String purchaseAmount = getUserInput();
        return purchaseAmount;
    }

    public String inputWinningNumber() {
        System.out.println(InputConstant.WINNING_NUMBER.getMessage());
        String winningNumber = getUserInput();
        return winningNumber;
    }

    private String getUserInput() {
        return Console.readLine();
    }
}
