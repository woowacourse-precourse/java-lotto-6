package lotto.view;

import lotto.config.LottoConfig;

public class InputValidator {
    private final String typeRegex = "^[0-9]*$";

    public void validateInputType(String input){
        if(isNotNumber(input)){
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_INPUT_TYPE_ERROR_MESSAGE.getMessage());
        }
    }

    public void validateInputNumberRange(int input){
        if(isOutOfRange(input)){
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE_ERROR_MESSAGE.getMessage());
        }
    }

    public void validateInputAmountUnit(int input){
        if(isNotUnit(input)){
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_A_UNIT_ERROR_MESSAGE.getMessage());
        }
    }

    private boolean isNotNumber(String input){
        return !input.matches(typeRegex);
    }

    private boolean isNotUnit(int input){
        return input % LottoConfig.LOTTO_BUYING_UNIT.getValue() != 0;
    }
    private boolean isOutOfRange(int input){
        return input < LottoConfig.LOTTO_NUMBER_START_INCLUSIVE.getValue() || input > LottoConfig.LOTT0_NUMBER_END_INCLUSIVE.getValue();
    }
}
