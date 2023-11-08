package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Validator;

public class InputView {

    public static String inputPurchaseAmount() throws IllegalArgumentException{
        String purchaseAmount = Console.readLine();
        Validator.checkInputForm(purchaseAmount);
        return Validator.checkNullValue(purchaseAmount);
    }

    public static String inputWinningNumber(){
        String winningNumber = Console.readLine();
        Validator.checkWinningNumberForm(winningNumber);
        return Validator.checkNullValue(winningNumber);
    }

    public static String inputBonusNumber() {
        String bonusNumber = Console.readLine();
        Validator.checkBonusNumberForm(bonusNumber);
        return Validator.checkNullValue(bonusNumber);
    }
}
