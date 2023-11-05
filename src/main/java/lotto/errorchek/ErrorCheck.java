package lotto.errorchek;

import lotto.fixeddata.ErrorText;
import lotto.fixeddata.NumberData;

public class ErrorCheck {
    private static long IsNumber64bit(String input){
        try{
            return Long.parseLong(input);
        }
        catch(NumberFormatException ex) {
            throw new IllegalArgumentException(ErrorText.ERROR+ErrorText.BUY_MONEY_NUMBER_ERROR+ErrorText.NOT_NUMBER);
        }
    }

    private static void MoneyRange(long input){
        if(input>= NumberData.MONEY_RANGE_MIN&&input<=NumberData.MONEY_RANGE_MAX) {
            UnitConfirmation(input);
            return;
        }
        throw new IllegalArgumentException(ErrorText.ERROR+ErrorText.BUY_MONEY_RANGE_ERROR);
    }


    private static void UnitConfirmation(long input){
        if(input%1000==0) {
            return;
        }
        throw new IllegalArgumentException(ErrorText.ERROR+ErrorText.BUY_MONEY_NUMBER_ERROR+ErrorText.INCORRECTLY_NUMBER);
    }

    public static long MoneyInput(String input) {
        long money = IsNumber64bit(input);
        MoneyRange(money);
        return money;
    }
}
