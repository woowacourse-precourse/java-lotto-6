package lotto;

import static lotto.Constant.*;

public class Validation {
    public static int validateMoney(String input){
        int money = 0;
        try{
            money = validateInteger(input);
            validateDivideBy1000(money);
        } catch(IllegalArgumentException e){
            System.out.print(e.getMessage());
            UI.getMoney();
        }
        return money;
    }
    private static int validateInteger(String input){
        int money;
        try {
            money = Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(INPUT_NUMBER_EXCEPTION_MSG);
        }
        return money;
    }

    private static void validateDivideBy1000(int money){

    }
}
