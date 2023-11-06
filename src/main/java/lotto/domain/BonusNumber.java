package lotto.domain;

import java.util.List;
import java.util.regex.Pattern;
import lotto.message.ExceptionMessage;

public class BonusNumber {
    private static final String BONUS_NUMBER_REGEXP = "^[0-9]+$";
    private final int bonusNumber;

    public BonusNumber(WinningNumber winningNumber, String input){
        validateInput(input);
        int bonusNumber = parseBonusNumber(input);
        validateOverlap(winningNumber.getWinningNumbers(),bonusNumber);
        validateRange(bonusNumber);

        this.bonusNumber = bonusNumber;
    }

    private void validateInput(String input){
        if(!Pattern.matches(BONUS_NUMBER_REGEXP,input)){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BONUS_TYPE.getMessage());
        }
    }

    private void validateOverlap(List<Integer> winningNumbers, int bonusNumber){
        for(int number:winningNumbers){
            if(number == bonusNumber){
                throw new IllegalArgumentException(ExceptionMessage.INVALID_BONUS_OVERLAP.getMessage());
            }
        }
    }

    private void validateRange(int bonusNumber){
        if(bonusNumber<1 || bonusNumber>45){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BONUS_RANGE.getMessage());
        }
    }

    public int parseBonusNumber(String input){
        return Integer.parseInt(input);
    }

    public int getBonusNumber(){
        return bonusNumber;
    }
}
