package lotto.view.validator;

import lotto.domain.constant.LottoConstant;
import lotto.view.exception.LottoInputException;
import lotto.view.message.LottoInputExceptionMessage;

public class MoneyToBuyLottoInputValidator {
    public void validate(String userInput){
        isNotEmpty(userInput);
        isNotNumeric(userInput);
        isNotDivisibleWithLottoPrice(userInput);
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
            throw LottoInputException.of(LottoInputExceptionMessage.MONEY_TO_BUY_LOTTO_IS_NOT_NUMERIC_TYPE);
        }
    }

    private void isNotDivisibleWithLottoPrice(String userInput){
        if(!divisibleWithLottoPrice(userInput)){
            throw LottoInputException.of(LottoInputExceptionMessage.MONEY_TO_BUY_IS_NOT_DIVISIBLE_WITH_LOTTO_PRICE);
        }
    }

    private boolean divisibleWithLottoPrice(String userInput){
        return ( Long.parseLong(userInput) % LottoConstant.LOTTO_PRICE.getValue() == 0 );
    }
}