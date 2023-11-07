package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Message;
import lotto.domain.BonusNumber;

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

        return amount;
    }

    public List<Integer> inputWinningNumber(){
        System.out.println(WinningNumbersMessage);
        String input = Console.readLine();

        validateNotEmptyInput(input);
        List<Integer> numbers = validateSplittedInput(input);

        return numbers;
    }

    public BonusNumber inputBonusNumber(){
        System.out.println(BonusNumberMessage);
        String input = Console.readLine();

        validateNotEmptyInput(input);
        int bonusNumber = validateInputIsNumeric(input);
        validatePositiveNumber(bonusNumber);

        return new BonusNumber(bonusNumber);
    }



}
