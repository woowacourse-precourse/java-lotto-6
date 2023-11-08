package lotto.Validator;

import lotto.Print.ErrorMessage;

public class Validator {

    //입력받은 구입 금액 유효성 검사
    public static int checkLottoBuyPrice(String inputValue) {
        try{
            int buyPrice = Integer.parseInt(inputValue);
            if(buyPrice % 1000 != 0 || buyPrice == 0){
                throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_PRICE_ERROR);
            }
            return buyPrice;
        }catch(NumberFormatException exception){
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT);
        }
    }
}