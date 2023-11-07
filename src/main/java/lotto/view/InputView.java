package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.UserInputValidator;

public class InputView {

    private static String getUserInput(){
        return Console.readLine();
    }

    public static int getPerchaseAmount(){
        String userInput = getUserInput();
        int amount = UserInputValidator.validatePurchaseAmount(userInput);
        return amount;
    }
}
