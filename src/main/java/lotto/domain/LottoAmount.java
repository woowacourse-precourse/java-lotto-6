package lotto.domain;

import lotto.view.Message;

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
            Message.typeException();
            throw new IllegalArgumentException();
        }
    }


    private static void checkPositive(int amount)
    {
        if(amount<=0){
            Message.rangeException();
            throw new IllegalArgumentException();
        }
    }

    private void checkFormat(int amount){
        if(amount%LOTTO_PRICE !=0){
            Message.numberFormatException();
            throw new IllegalArgumentException();

        }
    }

}
