package lotto.service;
import lotto.consts.ExceptionMessage;

import static lotto.consts.ConstsString.TICKET_PRICE;
import static lotto.consts.ConstsString.ZERO;

public class ValidationPrice {

    public void validateProcessor(int inputNum){
        validatePrice(inputNum);
        isPositiveNumber(inputNum);
    }
    public void validatePrice(int inputNum){
        if(inputNum % TICKET_PRICE != ZERO){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_TINPUT_PRICE.getMessage());
        }
    }

    public void isPositiveNumber(int inputNum){
        if(inputNum < ZERO){
            throw new IllegalArgumentException(ExceptionMessage.NEGATIVE_INPUT_ERROR.getMessage());
        }
    }

    public int checkInteger(String inputNum){
        try{
            return Integer.parseInt(inputNum);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_NUMBER.getMessage());
        }
    }
}
