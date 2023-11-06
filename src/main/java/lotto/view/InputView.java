package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Message;

import java.sql.SQLOutput;
import java.util.List;

import static lotto.Message.*;
import static lotto.Validator.*;

public class InputView {

    public int inputPurchaseAmount(){
        System.out.println(purchaseAmountMessage);
        String input = Console.readLine();

        validateNotEmptyInput(input);
        int amount = validateInputIsNumeric(input);
        validatePositiveNumber(amount);
        validateNotHasRemainder(amount);

        return amount;
    }

    public List<Integer> inputWinningNumber(){
        System.out.println(WinningNumbersMessage);
        String input = Console.readLine();

        validateNotEmptyInput(input);
        List<Integer> numbers = validateSplittedInputLengthIsSix(input);
        validateComposedOfUniqueNumbers(numbers);

        return numbers;
    }

    public void inputBonusNumber(List<Integer> winningNumbers){
        System.out.println(BonusNumberMessage);
        String input = Console.readLine();

        validateNotEmptyInput(input);
        int bonusNumber = validateInputIsNumeric(input);
        validatePositiveNumber(bonusNumber);
        validateNumberInRange(bonusNumber);
        winningNumbers.add(bonusNumber);
        validateComposedOfUniqueNumbers(winningNumbers);

    }



}
