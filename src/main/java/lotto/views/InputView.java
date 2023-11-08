package lotto.views;

import camp.nextstep.edu.missionutils.Console;
import lotto.configs.Constant;
import lotto.models.Lotto;
import lotto.utils;

public class InputView {
    public String readPurchaseAmount(){
        String input = Console.readLine();
        validatePurchaseAmount(input);
        return input;
    }

    public String readWinningNumber(){
        String input = Console.readLine();
        validateWinningNumber(input);
        return input;
    }

    public String readBonusNumber(Lotto lotto) {
        String input = Console.readLine();
        validateBonusNumber(lotto, input);
        return input;
    }

    private void validateBonusNumber(Lotto lotto, String input){
        validateNumber(input);
        if(lotto.hasNumber(Integer.parseInt(input))){
            throw new IllegalArgumentException(utils.createErrorMessage(Constant.ERROR_MESSAGE_DUPLICATED_NUMBER));
        }
    }

    private void validateWinningNumber(String input){
        String[] splitedString = input.split(Constant.COMMA);
        if(splitedString.length != Constant.LOTTO_COUNT){
            throw new IllegalArgumentException(utils.createErrorMessage(Constant.ERROR_MESSAGE_NOT_ENOUGH));
        }
        for(String string : splitedString){
            validateNumber(string);
        }
    }

    private void validateNumber(String input){
        if(!utils.isInteger(input)){
            throw new IllegalArgumentException(utils.createErrorMessage(Constant.ERROR_MESSAGE_INVALID_NUMBER));
        }
    }

    private void validatePurchaseAmount(String input){
        validateNumber(input);
        if(Integer.parseInt(input) % Constant.LOTTO_PRICE != 0){
            throw new IllegalArgumentException(utils.createErrorMessage(Constant.ERROR_MESSAGE_INVALID_UNIT));
        }
    }
}
