package view;

import camp.nextstep.edu.missionutils.Console;
import validator.PurchaseAmountValidator;
import validator.Validator;
import validator.WinningNumbersValidator;

import java.util.List;

import static util.message.InputMessage.GET_PURCHSE_AMOUNT;
import static util.message.InputMessage.GET_WINNING_NUMBERS;

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
}
