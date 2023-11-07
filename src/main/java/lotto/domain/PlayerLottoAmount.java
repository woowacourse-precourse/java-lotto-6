package lotto.domain;

import lotto.view.ExceptionMessage;

public class PlayerLottoAmount {

    public PlayerLottoAmount(String amount){
        int playerPrice = validateNumber(amount);
        validateNumberDivide(playerPrice);
        }

    private static void validateNumberDivide(int playerPrice) {
        if(playerPrice!=1000){
            ExceptionMessage.numberNotDivideException();
            throw new IllegalArgumentException();
        }

}

    private static int validateNumber(String amount) throws IllegalArgumentException{
        try{
            return Integer.parseInt(amount);
        }
        catch(NumberFormatException e){
            ExceptionMessage.numberException();
            throw new IllegalArgumentException();
        }
        finally{

        }

    }
}
