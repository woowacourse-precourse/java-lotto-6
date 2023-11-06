package lotto;

import static lotto.UI.*;
import static lotto.Constant.*;

public class Validation {
    public static void validateMoney(String input) throws IllegalArgumentException{
        int money = validateInteger(input);
        validateDivideBy1000(money);
    }
    private static int validateInteger(String input){
        try {
            return Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(INPUT_NUMBER_EXCEPTION_MSG);
        }
    }

    private static void validateDivideBy1000(int money){
        if (money % 1000 != 0){
            throw new IllegalArgumentException(INPUT_NOT_DIVIDE_EXCEPTION_MSG);
        }
    }
}
