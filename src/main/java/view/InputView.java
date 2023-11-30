package view;

import camp.nextstep.edu.missionutils.Console;
import view.validator.BonusValidator;
import view.validator.PurchaseAmountValidator;
import view.validator.WinningNumbersValidator;

import java.util.List;

import static util.message.InputMessage.*;

public class InputView {
    public static int inputPurchaseAmount(){
        System.out.println(GET_PURCHSE_AMOUNT.getValue());
        String input = Console.readLine();
        return PurchaseAmountValidator.validate(input);
    }

    public static List<Integer> inputWinngingNumbers(){
        System.out.println(GET_WINNING_NUMBERS.getValue());
        String input = Console.readLine();
        return WinningNumbersValidator.validate(input);
    }

    public static int inputBonusNumber(){
        System.out.println(GET_BONUS_NUMBER.getValue());
        String input = Console.readLine();
        return BonusValidator.validate(input);
    }
}
