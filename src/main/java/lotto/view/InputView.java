package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.Validator.*;

public class InputView {

    public int enterPurchaseAmount(){
        String input = Console.readLine();

        validateNotEmptyInput(input);
        int amount = validateInputIsNumeric(input);
        validatePositiveNumber(amount);
        validateNotHasRemainder(amount);

        return amount;
    }

}
