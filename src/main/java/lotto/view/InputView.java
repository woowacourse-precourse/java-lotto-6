package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Message;

import java.util.List;

import static lotto.Message.WinningNumbersMessage;
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

    public List<Integer> enterWinningNumber(){
        System.out.println(WinningNumbersMessage);
        String input = Console.readLine();

        validateNotEmptyInput(input);
        List<Integer> numbers = validateSplittedInputLengthIsSix(input);
        validateComposedOfUniqueNumbers(numbers);

        return numbers;
    }





}
