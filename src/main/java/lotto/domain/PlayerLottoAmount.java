package lotto.domain;

import lotto.view.ExceptionMessage;

public class PlayerLottoAmount {

    public PlayerLottoAmount(String amount){
        validateNumber(amount);
    }

    private static int validateNumber(String amount) throws IllegalArgumentException{
        try{
            return Integer.parseInt(amount);
        }
        catch(NumberFormatException e){
            ExceptionMessage.numberException();
            throw new IllegalArgumentException();
        }

    }
}
