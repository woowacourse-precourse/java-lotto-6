package lotto.service;

import lotto.service.exception.HandleNumberFormattingException;
import lotto.service.exception.InputErrorMessage;
import lotto.service.exception.HandleIllegalArgumentException;

public class BuyingLottoService {

    public int validateMoney(String input){
        int validMoney;
        try {
            verifyNumberFormat(input);
            verifyMoneyUnit(convertStringtoInt(input));
            verifyRange(convertStringtoInt(input));

        } catch (HandleNumberFormattingException | HandleIllegalArgumentException e){
            System.out.println(e.getMessage());
            return -1;
        }
        validMoney = convertStringtoInt(input);
        return validMoney;
    }

    public int convertStringtoInt(String input){
        return Integer.parseInt(input);
    }

    private void verifyNumberFormat(String moneyInput){
        try{
            Integer.parseInt(moneyInput);
        }catch(NumberFormatException e) {
            throw new HandleNumberFormattingException(InputErrorMessage.INVALID_NUMBER);
        }
    }

    private void verifyMoneyUnit(int moneyInput){
        if (moneyInput % 1000 != 0) {
            throw new HandleIllegalArgumentException(InputErrorMessage.WRONG_INPUT_MONEY_UNIT);
        }
    }

    private void verifyRange(int moneyInput){
        if(moneyInput>50000){
            throw new HandleIllegalArgumentException(InputErrorMessage.OVER_RANGE_MONEY);
        }
    }
}
