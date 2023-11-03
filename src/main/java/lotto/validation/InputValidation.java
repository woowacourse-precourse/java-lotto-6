package lotto.validation;


import lotto.constants.Constants;

public class InputValidation {

    public void checkRemainder(int money){
        if(money % Constants.LOTTO_PRICE != Constants.ZERO){
             throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주세요");
        }
    }

}
