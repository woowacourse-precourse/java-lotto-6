package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.UserInputValidator;

public class InputView {

    private static String getUserInput(){
        return Console.readLine();
    }

    public static int getPerchaseAmount() throws IllegalArgumentException{
        try{
            String userInput = getUserInput();
            int amount = UserInputValidator.validatePurchaseAmount(userInput);
            return amount;
        }
        catch(IllegalArgumentException ex){
            throw new IllegalArgumentException(ex.getMessage());
        }
    }
}
