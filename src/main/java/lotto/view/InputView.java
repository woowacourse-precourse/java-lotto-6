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
        return Validator.checkNullValue(Console.readLine());
    }

    public static String inputBonusNumber() {
        return Validator.checkNullValue(Console.readLine());
    }
}
