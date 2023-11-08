package lotto.validator;

import lotto.constants.ErrorMessage;
import lotto.constants.LottoConstant;

import java.util.ArrayList;

public class AmountValidator {

    private ErrorMessage errorMessage;
    private int lottoPrice;
    private int resultAmount;

    public AmountValidator() {
        lottoPrice = LottoConstant.LOTTO_PRICE.getConstant();
        resultAmount = 0;
    }

    public boolean validate(String buyAmount) {

        if (!validAmountOtherString(buyAmount)) {
            return false;
        }
        if(!validAmountLess1000(resultAmount)) {
            return false;
        }
        if(!validAmountUndivided1000(resultAmount)) {
            return false;
        }

        return true;
    }

    public boolean validAmountOtherString(String buyAmount) {
        try {
            resultAmount = Integer.parseInt(buyAmount);
        }
        catch (IllegalArgumentException e) {
            errorMessage = ErrorMessage.ERROR_AMOUNT_OTHER_STRING;
            return false;
        }

        return true;
    }

    public boolean validAmountLess1000(int num) {
        try {
            if(num < lottoPrice) {
                throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException e) {
            errorMessage = ErrorMessage.ERROR_AMOUNT_LESS_1000;
            return false;
        }

        return true;
    }

    public boolean validAmountUndivided1000(int num) {
        try {
            if(num % lottoPrice != 0) {
                throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException e) {
            errorMessage = ErrorMessage.ERROR_AMOUNT_UNDIVIDED_1000;
            return false;
        }

        return true;
    }


    public String getErrorMessage() {
        if(errorMessage != null)
            return errorMessage.getErrorMessage();
        return "";
    }

    public int getResultAmount() {
        return resultAmount / lottoPrice;
    }
}
