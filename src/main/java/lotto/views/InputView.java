package lotto.views;

import camp.nextstep.edu.missionutils.Console;
import lotto.configs.Constant;
import lotto.utils;

public class InputView {
    public String readPurchaseAmount(){
        String input = Console.readLine();
        validatePurchaseAmount(input);
        return input;
    }

    private void validatePurchaseAmount(String input){
        if(!utils.isInteger(input)){
            throw new IllegalArgumentException(utils.createErrorMessage(Constant.ERROR_MESSAGE_INVALID_NUMBER));
        }
        if(Integer.parseInt(input) % Constant.LOTTO_PRICE != 0){
            throw new IllegalArgumentException(utils.createErrorMessage(Constant.ERROR_MESSAGE_INVALID_UNIT));
        }
    }
}
