package lotto.view.validator;

import lotto.domain.constant.LottoConstant;
import lotto.view.constant.InputConstant;
import lotto.view.exception.LottoInputException;
import lotto.view.message.LottoInputExceptionMessage;

public class UserMoneyInputValidator {
    public void validate(String userInput){
        isNotEmpty(userInput);
        isNotNumeric(userInput);
        isDivisibleWithLottoPrice(userInput);
    }

    private void isNotEmpty(String userInput){
        if(userInput.isEmpty()){
            throw LottoInputException.of(LottoInputExceptionMessage.INPUT_IS_EMPTY);
        }
    }

    private void isNotNumeric(String userInput){
        try{
            Long.parseLong(userInput);
        } catch(NumberFormatException e){
            throw LottoInputException.of(LottoInputExceptionMessage.USER_MONEY_IS_NOT_NUMERIC_TYPE);
        }
    }

    private void isDivisibleWithLottoPrice(String userInput){
        if(!divisibleWithLottoPrice(userInput)){
            throw LottoInputException.of(LottoInputExceptionMessage.USER_MONEY_IS_NOT_DIVISIBLE_WITH_LOTTO_PRICE);
        }
    }

    private boolean divisibleWithLottoPrice(String userInput){
        return Long.parseLong(userInput) % LottoConstant.LOTTO_PRICE.getValue() == InputConstant.ZERO;
    }
}