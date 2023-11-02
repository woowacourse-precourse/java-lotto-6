package lotto.service;

import lotto.constant.ErrorMessage;

public class ValidateService {
    public int validateNumber(String inputValue){
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NUMBER_ERROR.getMessage());
        }
    }
}
