package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Message;

import static lotto.Message.purchaseAmountMessage;
import static lotto.Validator.*;

public class InputView {

    public int enterPurchaseAmount(){
        System.out.println(purchaseAmountMessage);
        String input = Console.readLine();

        validateNotEmptyInput(input);
        int amount = validateInputIsNumeric(input);
        validatePositiveNumber(amount);
        validateNotHasRemainder(amount);

        return amount;
    }



}
