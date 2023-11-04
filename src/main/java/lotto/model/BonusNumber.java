package lotto.model;

import lotto.constant.ErrorMessage;

public class BonusNumber {

    private int number;

    public BonusNumber(String input, Lotto winningNumbers){
        int tempNumber = notNumber(input);
        overlapWinningNumber(tempNumber, winningNumbers);
    }

    private int notNumber(String input){
        try{
            return Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_BONUS_NUMBER);
        }
    }

    private void overlapWinningNumber(int tempNumber, Lotto winningNumbers){
        if(winningNumbers.containNumbers(tempNumber)){
            throw new IllegalArgumentException(ErrorMessage.OVERLAP_BONUS_NUMBER);
        }
    }

}
