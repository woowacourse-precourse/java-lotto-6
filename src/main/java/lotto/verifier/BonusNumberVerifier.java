package lotto.verifier;

import lotto.system.Constant;
import lotto.system.ExceptionMessage;

public class BonusNumberVerifier implements Verifier{
    @Override
    public void check(String input) {
        checkNumeric(input);
        checkRange(input);

    }

    private void checkNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_NUMERIC);
        }
    }

    private void checkRange(String input){
        int BonusNumber = Integer.parseInt(input);
        if(BonusNumber < Constant.START_INCLUSIVE || BonusNumber > Constant.END_INCLUSIVE ){
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_EACH_OUT_OF_RANGE);
        }
    }
}
