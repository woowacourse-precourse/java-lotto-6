package view;

import camp.nextstep.edu.missionutils.Console;
import validator.PurchaseAmountValidator;
import validator.Validator;

import static util.message.InputMessage.GET_PURCHSE_AMOUNT;
import static util.message.InputMessage.GET_WINNING_NUMBERS;

public class InputView {
    public static int inputPurchaseAmount(){
        System.out.println(GET_PURCHSE_AMOUNT.getValue());
        String input = Console.readLine();
        return PurchaseAmountValidator.isRightPurchaseAmount(input);
    }

    public static String inputWinnging(){
        System.out.println(GET_WINNING_NUMBERS.getValue());
        return Console.readLine();
    }
}
