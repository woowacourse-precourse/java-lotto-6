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

    public String inputBonusNumber() {
        System.out.println(InputConstant.BONUS_NUMBER.getMessage());
        String bonusNumber = getUserInput();
        return bonusNumber;
    }

    private String getUserInput() {
        return Console.readLine();
    }
}
