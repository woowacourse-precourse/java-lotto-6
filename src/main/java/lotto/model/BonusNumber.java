package lotto.model;

import lotto.constant.ErrorMessage;

public class BonusNumber {

    private int number;

    public BonusNumber(String input){
        int tempNumber = notNumber(input);
    }

    private int notNumber(String input){
        try{
            return Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_BONUS_NUMBER);
        }
    }

}
