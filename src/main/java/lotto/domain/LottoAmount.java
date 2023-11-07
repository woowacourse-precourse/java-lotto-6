package lotto.domain;

import static lotto.view.Constants.*;
import static lotto.view.Message.*;

public class LottoAmount {
    private final int amount;

    public LottoAmount(int amount){
        checkAmount(amount);
        this.amount =amount;
    }

    public int calcLottoNum(){
        return amount /LOTTO_PRICE;
    }

    private void checkAmount(int amount){
        checkNumber(amount);
        checkPositive(amount);
        checkFormat(amount);

    }
    private static int checkNumber(int amount) {
        try{
            return amount;
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException(NOT_NUMBER_ERROR);
        }
    }


    private static void checkPositive(int amount)
    {
        if(amount<=0){
            throw new IllegalArgumentException(RANGE_ERROR);
        }
    }

    private void checkFormat(int amount){
        if(amount%LOTTO_PRICE !=0){
            throw new IllegalArgumentException(INPUT_FORMAT_ERROR);

        }
    }

}
