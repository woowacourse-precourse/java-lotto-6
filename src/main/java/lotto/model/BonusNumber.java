package lotto.model;

import lotto.constant.ErrorMessage;
import lotto.constant.NumberConstant;

public class BonusNumber {

    private int number;

    public BonusNumber(String input, Lotto winningNumbers){
        int tempNumber = notNumber(input);
        overlapWinningNumber(tempNumber, winningNumbers);
        outOfRange(tempNumber);
        number = tempNumber;
    }

    private int notNumber(String input){
        try{
            return Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_BONUS_NUMBER);
        }
    }

    private void overlapWinningNumber(int tempNumber, Lotto winningNumbers){
        if(winningNumbers.containsNumber(tempNumber)){
            throw new IllegalArgumentException(ErrorMessage.OVERLAP_BONUS_NUMBER);
        }
    }

    private void outOfRange(int tempNumber){
        if(tempNumber < NumberConstant.LOTTO_NUMBER_MIN || tempNumber > NumberConstant.LOTTO_NUMBER_MAX){
            throw new IllegalArgumentException(ErrorMessage.OUT_RANGE_BONUS_NUMBER);
        }
    }

    public int getNumber(){
        return number;
    }

}
