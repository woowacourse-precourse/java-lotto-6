package lotto.view.validator;

import lotto.view.exception.LottoInputException;
import lotto.view.message.LottoInputExceptionMessage;

public class MoneyToBuyLottoInputValidator {
    public void validate(String userInput){
        isNumeric(userInput);
    }

    private void isNumeric(String userInput){
        try{
            Long.parseLong(userInput);
        } catch(NumberFormatException e){
            throw LottoInputException.of(LottoInputExceptionMessage.MONEY_TO_BUY_LOTTO_NOT_NUMERIC_TYPE);
        }
    }
}